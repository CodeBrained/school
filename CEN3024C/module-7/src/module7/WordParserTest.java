package module7;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.jupiter.api.Test;

class WordParserTest {

	@Test
	void uglyRegexTest() throws Exception {
		String testString = ("H,ell?o");
		testString = WordParser.uglyRegex(testString);
		if (testString.contains(",") == true || testString.contains("?") == true) {
			fail("The String contains either a ',' or a '?'");
		}
	}
	
	@Test
	void removeApoTest() throws Exception {
		WordParser wp = new WordParser();
		
		//Adding another ’ in the string below will result in a failure, proving the test 
		String raString = new String("Hello World ’ this is a string");
		String wordsTest[] = raString.toLowerCase().split(" ");
		List<String> wordList = wp.removeApo(wordsTest);
		
		for (int i = 0; i < wordList.size(); i++) {
			if (wordList.get(i).contains("’")) {
				fail("The String still contains a '’'");
			}
		}
	}
	
	
	@Test
	void countWordFreqTest() throws Exception {
		// sample unique words list
		List<String> s1 = new ArrayList<>(3);
		s1.add("horse");
		s1.add("pig");
		s1.add("cow");
		
		// sample list with duplicates
		List<String> s2 = new ArrayList<>(6);
		s2.add("horse");
		s2.add("horse");
		s2.add("horse");
		s2.add("cow");
		s2.add("cow");
		s2.add("pig");
		
		Hashtable<String, Integer> wordMap = WordParser.countWordFreq(s1, s2);
		// Prints the word frequencies to the console. 
		System.out.println(wordMap);
		
		// I changed the values to incorrect values to assure it wuld produce a failure
		// The current values will not produce a failure. 
		if (wordMap.get("horse")!=3) {
			fail("The method did not count horse as 3");
		}
		if (wordMap.get("pig")!=1) {
			fail("The method did not count pig as 1");
		}
		if (wordMap.get("cow")!=2) {
			fail("The method did not count cow as 2");
		}		
	}
}
