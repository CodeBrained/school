package module2;
import java.io.*;
import java.util.*;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

public class Main {

	//private static final String HashTable  = null;

	public static void main(String[] args) throws Exception {
		String poemString = getText();
		poemString = uglyRegex(poemString);
		String words[] = poemString.toLowerCase().split(" ");
		//printText(words);
		
		int count = 0;
		List<String> wordsU = new ArrayList<String>();
		Hashtable<String, Integer> wordCount = new Hashtable<>();
		for (int i = 0; i < words.length; i++) {
			if (!wordsU.contains(words[i])) {
				wordsU.add(words[i]);
			}
		}
		
		for (int i = 0; i < wordsU.size(); i ++) {
			//System.out.println(wordsU.size());
			for (int j = 0; j < words.length; j++) {
				if (words[j] == wordsU.get(i)) {
					count++;
				}
			}
		System.out.println(wordsU.get(i) + ":" + count);
		
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
