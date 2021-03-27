package fileSearcher;

import java.io.*;
import java.util.*;
//java wanted lots of things during the making and testing of this so I just imported the entire util and io library
//DecimalFormat library will be used for turning the avg word length double into a num with 2 decimal places
import java.text.DecimalFormat;

public class TextStatistics2 implements TextStatisticsInterface{

	private File textFile;
	private int charCount;
	private int wordCount;
	private int lineCount;
	private int[] wordLength;
	private int[] letterCount;
	private static final String DELIMITERS = "[\\W\\d_]+";
	
	/**
	 * Constructor: takes care of all the heavy lifting and does all the computation/logic behind the file
	 * @param textFile is the incoming file that will be probed/analyzed for all sorts of goodies 
	 */
	public TextStatistics2(File textFile) {
		//sets this files textFile object to the passed in text file object
		this.textFile = textFile;
		try {
			//creates fileScanner object to read the file
			Scanner fileScanner = new Scanner(textFile);
			//creates list of the top 24 word lengths, if value is 0, a function later will take care of/ignore it		
			wordLength = new int[24];
			//num chars in in file
			charCount = 0;
			//creates list of letters in alphabet
			letterCount = new int[26];
			//this helps get the count of all chars since newline characters and spaces are also technically chars and can't be ignored during the char count 
			int otherChars = 0;
			//while scanner has nextline, add 1 to lineCount and get stats for that line
			while(fileScanner.hasNextLine()) {
				
				lineCount++;
				String line = fileScanner.nextLine();
				
				//counts the occurrences of letters
			    char currentCharacter; 
				for (int i = 0; i < line.length(); i++) {
					currentCharacter = line.toLowerCase().charAt(i);
					if(currentCharacter >= 'a' && currentCharacter <= 'z') {
						letterCount[currentCharacter - 'a']++;
					}
					else
						otherChars++;
				}
						
				
				Scanner lineScanner = new Scanner(line);
				
				lineScanner.useDelimiter(DELIMITERS);			
				
				//gets frequency of words in file
				while(lineScanner.hasNext()) {
					//adds 1 to word count
					wordCount++;					
					String word = lineScanner.next();
					
					for(int i = 0; i < wordLength.length; i++) {
						if(i == word.length()) {
							wordLength[i]++;
						}
					}
									
				}
				
				lineScanner.close();
			}
			fileScanner.close();
			
			//adds chars to otherChars 
			for(int letterNumber : letterCount) {
				charCount += letterNumber;
			}
			charCount += otherChars + lineCount;
			
		}
		catch(FileNotFoundException e) {	
	    	//if error, print error message
	        System.out.println("An error occurred.");
		}
	}
	
	/** @returns average word length */
	public double getAverageWordLength() {
		//average word length is equal to letters divided by total words
		int result = 0;
		int totalWords = 0;
		for(int i = 1; i < wordLength.length; i++) {
			if(wordLength[i] != 0) {
				result += i * wordLength[i];
				totalWords += wordLength[i];
			}
		}
		
		//converts average to 2 decimal points
		double averageLength = (double) result / totalWords;
		averageLength = (double) Math.round(averageLength * 100) / 100;
		//returns average length
		return averageLength;
	}
	
	/** @returns num chars in file */
	public int getCharCount() {
		return charCount;
	}
	
	/** @returns num words in file */
	public int getWordCount() {
		return wordCount;
	}
	
	/** @returns num lines in file */
	public int getLineCount() {
		return lineCount;
	}
	
	/** @returns the occurrences of letters in file */
	public int[] getLetterCount() {
		return letterCount;
	}
	
	/** @returns the length of words in file */
	public int[] getWordLengthCount() {
		return wordLength;
	}
	
	/** @returns all data that the TextStatistics2 functions could return */
	public String toString() {	
		//decimal format object to set average word length to 2 decimal places
		DecimalFormat numFormat = new DecimalFormat("#.00");
		//string containing simple variables; lines, words, chars, file name
		String stats = "Statistics for " + textFile.getName() + "\n==========================================================\n" + lineCount + " lines\n" + wordCount + " words\n" + charCount + " characters\n------------------------------\n";
		//while redoing this, I found a faster way to print out the alphabet, prints out all chars in the alphabet and the num occurrences for each
		for(int i = 0; i < letterCount.length/2; i++) {
			stats += (char) (i + 'a') + " = " + letterCount[i] + "\t\t" + (char) (i + 'n') + " = " + letterCount[i + ('n'-'a')] + "\n";
		}
		//start the word length and frequency stats
		stats += "------------------------------\nlength\tfrequency\n------\t---------\n";
		
		//for i less than or equal to wordLength length, add that number (word length) and it's occurrences to the stats string
		for(int i = 1; i < wordLength.length; i++) {
			//adds word length and it's frequency to the stats as long as the length is greater than 0
			if(wordLength[i] != 0) {
				stats += i + "\t" + wordLength[i] + "\n";
			}
		}
		
		//add average word length to stats and end string with newline char in case there is a new file being read immediately afterwards
		stats += "\nAverage word length = " + numFormat.format(getAverageWordLength()) + "\n==========================================================\n";
		//return stats
		return stats;
	}
}

