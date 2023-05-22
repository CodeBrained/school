package module2;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		String text = getText();
		System.out.print(text);

	}
	
	//reads the file and converts it to a string
	public static String getText() throws Exception {
		String text = new String();
		FileReader reader = new FileReader("TheRavenPoemWithHTMLTags.txt");
		
		int i;
		while ((i = reader.read()) != -1) {
			text += (char)i;
		}
		
		reader.close();
		return text;
	}

}
