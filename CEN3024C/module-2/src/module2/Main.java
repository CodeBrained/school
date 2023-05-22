package module2;
import java.io.*;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

public class Main {

	public static void main(String[] args) throws Exception {
		//getText();
		String poemString = getText();

		poemString = poemString.replaceAll("[,]", " ");
		poemString = poemString.replaceAll("[.]", " ");
		poemString = poemString.replaceAll("[-]", " ");
		poemString = poemString.replaceAll("[—]", " ");
		poemString = poemString.replaceAll("[\"]", " ");
		poemString = poemString.replaceAll("[“]", " ");
		poemString = poemString.replaceAll("[”]", " ");
		poemString = poemString.replaceAll("[!]", " ");
		poemString = poemString.replaceAll("[;]", " ");
		poemString = poemString.replaceAll("[?]", " ");
		poemString = poemString.replaceAll("  ", " ");
		poemString = poemString.replaceAll("  ", " ");

		String words[] = poemString.toLowerCase().split(" ");
		for (int i = 0; i < words.length; i++) {
			//words[i] = words[i].replaceAll("[^A-Za-z']", " ");
			System.out.println(words[i]);
		}
			
	}
	
	public static String getText() throws Exception {
		// Parse the HTML text into a Document object
		File input = new File("TheRavenPoemWithHTMLTags.txt");
		Document doc = Jsoup.parse(input, "UTF-8");
		
		// Get the title of the poem
		Element title = doc.getElementsByTag("h1").first();
		String titleText = title.text();
		//System.out.println(titleText);
		
		// Get the subtitle of the poem (author name)
		Element author = doc.getElementsByTag("h2").first();
		String authorText = author.text();
		//System.out.println(authorText);
		
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
}
