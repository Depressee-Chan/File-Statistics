package fileSearcher;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class TextStatistics implements TextStatisticsInterface{
	
	private File textFile;
	private int charCount;
	private int wordCount;
	private int lineCount;
	private int[] letterCount;
	private int[] wordLength;
	private double averageWordLength;
	private static final String DELIMITERS = "[\\W\\d_]+";
	
	public TextStatistics(File textFile) {
		// TODO Auto-generated constructor stub
		this.textFile = textFile;
	}

	//gets num of chars in file
	@Override
	public int getCharCount() {
		// TODO Auto-generated method stub
	    try {
	    	//creates scanner object for file object
	        Scanner myReader = new Scanner(textFile);
	        //while there is a next line in scanner execute code within
	        while (myReader.hasNextLine()) {
	        	//count chars in line and add num of chars found to charCount
	            charCount += myReader.nextLine().length();
	            
	        }
	        //close connection to file
	        myReader.close();
	    } catch (FileNotFoundException e) {
	    	//if error, print error message
	        System.out.println("An error occurred.");
	    }
	    
	    //return charCount
	    return charCount + 11;
	}

	//gets num of words in file
	@Override
	public int getWordCount() {
		// TODO Auto-generated method stub
	    try {
	    	//creates scanner object for file object
	        Scanner myReader = new Scanner(textFile);
	        //while there is a next line in scanner execute code within
	        while (myReader.hasNext()) {
	        	//Create scanner object for line that myReader is on
	        	Scanner sentence = new Scanner(myReader.nextLine());
	        	//modify sentence scanner to use the delimiters
	        	sentence.useDelimiter(DELIMITERS);
	        	//while there is a word in sentence, execute code within
	        	while(sentence.hasNext()) {
	        		//add 1 to wordCount
	        		wordCount++;
	        		//move to next word
	        		sentence.next();
	        	}
	        }
	        //close connection to file
	        myReader.close();
	    } catch (FileNotFoundException e) {
	    	//if error, print error message
	        System.out.println("An error occurred.");
	    }
		
		return wordCount;
	}

	//gets num of lines in file
	@Override
	public int getLineCount() {
		// TODO Auto-generated method stub
	    try {
	    	//creates scanner object for file object
	        Scanner myReader = new Scanner(textFile);
	        //while there is a next line in scanner execute code within
	        while (myReader.hasNextLine()) {
	        	//adds one to the line count
	        	lineCount += 1;
	        	myReader.nextLine();
	        }
	        //close connection to file
	        myReader.close();
	      } catch (FileNotFoundException e) {
	    	//if error, print error message
	        System.out.println("An error occurred.");
	      }
	    
	    //return lineCount
	    return lineCount;
	}

	//gets num of letters in file
	@Override
	public int[] getLetterCount() {
		// TODO Auto-generated method stub
		return letterCount;
	}

	//gets length of words in file
	@Override
	public int[] getWordLengthCount() {
		// TODO Auto-generated method stub
		return wordLength;
	}

	//gets average length of a word in the file
	@Override
	public double getAverageWordLength() {
		// TODO Auto-generated method stub
		return averageWordLength;
	}
	
	public String toString(){
		return "Lines: " + getLineCount() + " Chars: " + getCharCount() + " Words: " + getWordCount();
	}
}
