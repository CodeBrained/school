package module2;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

public class Main {

	public static void main(String[] args) throws Exception {
		// Get the text from the HTML file and split into an array of words
		String poemString = getText();
		poemString = uglyRegex(poemString);
		String words[] = poemString.toLowerCase().split(" ");
		System.out.println("Rank : Word         : Frequency\n--------------------------------");

		// Remove elements with only the ' character
		List<String> wordList = removeApo(words);

		// Create unique list
		List<String> wordsU = uniqueList(wordList);

		// Count the frequency of each word
		Hashtable<String, Integer> wordMap = countWordFreq(wordsU, wordList);
		
		// Sort the data		
		List<Map.Entry<String, Integer>> list = sortList(wordMap);

		//format and print top 20 words
		formatList(list);
	}

	public static String getText() throws Exception {
		// Parse the HTML text into a Document object
		File input = new File("TheRavenPoemWithHTMLTags.txt");
		Document doc = Jsoup.parse(input, "UTF-8");

		// Get the title of the poem
		Element title = doc.getElementsByTag("h1").first();
		String titleText = title.text();

		// Get the subtitle of the poem (author name)
		Element author = doc.getElementsByTag("h2").first();
		String authorText = author.text();

		// Get each paragraph from the poem
		String poemText = new String();
		Elements paragraphs = doc.getElementsByTag("p");
		for (int i = 0; i < paragraphs.size(); i++) {
			String paragraph = paragraphs.get(i).text();
			poemText += paragraph;
		}

		String finalText = titleText + " " + authorText + " " + poemText;
		return finalText;
	}
	
	// Removes unwanted characters
	public static String uglyRegex(String text) {

		text = text.replaceAll("[,]", " ");
		text = text.replaceAll("[.]", " ");
		text = text.replaceAll("[-]", " ");
		text = text.replaceAll("[—]", " ");
		text = text.replaceAll("[\"]", " ");
		text = text.replaceAll("[“]", " ");
		text = text.replaceAll("[”]", " ");
		text = text.replaceAll("[!]", " ");
		text = text.replaceAll("[;]", " ");
		text = text.replaceAll("[?]", " ");
		text = text.replaceAll("[:]", " ");
		text = text.replaceAll("  ", " ");
		text = text.replaceAll("  ", " ");
		return text;
	}
	
	/* Removes Apostrophe from list of unique words.
	   I added this separate because words like "demon's" were becoming "demon s" */
	public static List<String> removeApo(String[] words) {
		List<String> wordList = new ArrayList<>(Arrays.asList(words));
		wordList.remove("’");
		return wordList;
	}
	
	// Creates the list of unique words
	public static List<String> uniqueList(List<String> wordList) {
		List<String> wordsU = new ArrayList<String>();
		for (int i = 0; i < wordList.size(); i++) {
			if (!wordsU.contains(wordList.get(i))) {
				wordsU.add(wordList.get(i));
			}
		}
		return wordsU;
	}
	
	/* This method counts the frequency of each word by comparing the list of unique words against the list of all the words in The Raven.
	   In the future I want to re write this to use something other than Hashtable. */
	public static Hashtable<String, Integer> countWordFreq(List<String> wordsU, List<String> wordList) {
		int count = 0;
		Hashtable<String, Integer> wordMap = new Hashtable<>();
		for (int i = 0; i < wordsU.size(); i++) {
			for (int j = 0; j < wordList.size(); j++) {
				if (wordsU.get(i).equals(wordList.get(j))) {
					count++;
				}
			}
			wordMap.put(wordsU.get(i), count);
			count = 0;
		}
		return wordMap;
	}
	
	/* This method allows the list to be sorted using collections built in sort method.
	   I found this method at https://www.javacodeexamples.com/sort-hashtable-by-values-in-java-example/3169 */
	public static List<Map.Entry<String, Integer>> sortList(Hashtable<String, Integer> wordMap) {
		List<Map.Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(wordMap.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> entry1, Entry<String, Integer> entry2) {
				return entry2.getValue().compareTo(entry1.getValue()); // swapped entry1 and entry2
			}
		});
		return list;
	}
	
	// This list formats the data and prints it to the user. 
	public static void formatList(List<Map.Entry<String, Integer>> list) {
		Map<String, Integer> mapSortedByValues = new LinkedHashMap<String, Integer>();
		int count = 1;
		for (Map.Entry<String, Integer> entry : list) {
			mapSortedByValues.put(entry.getKey(), entry.getValue());
			if (count < 21) {
				System.out.println(String.format("%02d", count) + "   : " + String.format("%-12s", entry.getKey()) + " : "
						+ entry.getValue());
			}
			count++;
		}
	}
}

