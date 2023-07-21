# Module 2 - Word Parser

May 2023

## Steps: Outline

- [x] 1. Get the text from the HTML file and split into an array of words
- [x] 2. Remove elements with only the apostrophe character
- [x] 3. Create unique word list
- [x] 4. Count the frequency of each word
- [x] 5. Sort the data
- [x] 6. Format and print top 20 words
- [x] 7. JSoup

## Steps In-Depth

### 1. Get the text from the HTML file and split into an array of words

* First I created a file type object `input` to hold the data contained in the .txt file for The Raven.
* After I created `input` I created a Document type object named `doc` that uses the JSoup method `parse()` to read the file and encode it to UTF-8.
* A String `poemText` is created to hold the .txt file as a String type object. 
* `uglyRegex` is called to filter out unwanted characters from the String.
* The String is then split into an Array named `words` on the whitespace character .

### 2. Remove elements with only the apostrophe character

* At this point an apostrophe was being counted as a single word so I created a method `removeApo` to remove this from the Array of words.
* `words` is passed through `removeApo` and returned as a List of Strings `wordList`.

### 3. Create unique word list

* In order to count the frequency of words, a unique list must be made to compare against the original List containing all the words in the poem. 
* The method `uniqueList` is created to add unique words to a new List.
* This can be accomplished using a for loop that adds new words to `wordsU`, and while iterating through compares `wordsU` against `wordList`.
* `wordsU` is created in main to hold the new List of unique words.

### 4. Count the frequency of each word

* Create a method `countWordFreq` to count each occurence of a word, and save it as a key-value pair.
* Each String in `wordsU` is compared against each word in `wordList`, and count is incremented for wordsU[i].
* The word is put as a key in `wordMap` alongside `count` as the value in the pair.
* `count` is reset to 0 to continue counting for the next word in `wordsU`.
* `wordMap` is created in main and calls the `countWordFreq`.

### 5. Sort the data

* I found a method [here](https://www.javacodeexamples.com/sort-hashtable-by-values-in-java-example/3169) that allows for data to be retrieved in a sorted manner from a Hashtable. In the future I plan to change the Hashtable into another type. 
* To get the key value pairs in order of 1 through 20, I swapped entry1, and entry2 on line 122.
* `list` is created in the main function to hold the sorted data.

### 6. Format and print top 20 words

* `formatList` is created to format the list in an organized view for the user. 
* The `list` is passed through `formatList` to be printed to the 
console in order of 1-20.

### 7. JSoup

* In order for this to work the user must download JSoup and put it in the classpath.

# References

## Jsoup

* [Load HTML document from a file](https://jsoup.org/cookbook/input/load-document-from-file)
* [Parsing HTML tags in a string](https://jsoup.org/cookbook/input/parse-document-from-string)

## Misc

* [Reading a text file with Java](https://www.geeksforgeeks.org/different-ways-reading-text-file-java/)  
* [How to replace an asterisk character (*) in a RegEx expression](https://stackoverflow.com/questions/2801549/how-do-i-replace-an-actual-asterisk-character-in-a-regex-expression)
* [Sort a Hashtable by its values](https://www.javacodeexamples.com/sort-hashtable-by-values-in-java-example/3169)