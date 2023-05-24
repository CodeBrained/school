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
		System.out.println("Rank : Word : Frequency");

		// Remove elements with only the ' character
		List<String> wordList = new ArrayList<>(Arrays.asList(words));
		wordList.remove("’");

		// create unique list
		List<String> wordsU = new ArrayList<String>();
		for (int i = 0; i < wordList.size(); i++) {
			if (!wordsU.contains(wordList.get(i))) {
				wordsU.add(wordList.get(i));
			}
		}

		// count the frequency of each word
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

		List<Map.Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(wordMap.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> entry1, Entry<String, Integer> entry2) {
				return entry2.getValue().compareTo(entry1.getValue()); // swapped 1 and 2
			}
		});

		Map<String, Integer> mapSortedByValues = new LinkedHashMap<String, Integer>();

		count = 1;
		for (Map.Entry<String, Integer> entry : list) {
			mapSortedByValues.put(entry.getKey(), entry.getValue());
			if (count < 21) {
				System.out.println(String.format("%02d", count) + " : " + String.format("%10s", entry.getKey()) + " : "
						+ entry.getValue());
			}
			count++;
		}
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

	public static void printText(String[] words) {
		for (int i = 0; i < words.length; i++) {
			System.out.println(words[i]);
		}
	}
}