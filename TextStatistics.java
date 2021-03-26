package fileSearcher;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TextStatistics implements TextStatisticsInterface{
	
	private File textFile;
	private int charCount;
	private int wordCount;
	private int lineCount;
	private int[] letterCount = new int[26];
	private int totalLetters;
	//temporary list of word lengths to add to
	private ArrayList<Integer> tempList = new ArrayList<Integer>();
	ArrayList<Integer> lengthList = new ArrayList<Integer>();
	ArrayList<Integer> occurrenceList = new ArrayList<Integer>();
	private int[] wordLength;
	private double averageWordLength;
	private static final String DELIMITERS = "[\\W\\d_]+";
	
	//textStatistics constructor
	public TextStatistics(File textFile) {
		//sets textFile object to incoming object
		this.textFile = textFile;
	}

	//gets num of chars in file
	@Override
	public int getCharCount() {
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
	    return charCount + lineCount;
	}

	//gets num of words in file
	@Override
	public int getWordCount() {
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

	//gets num occurrences of letters in file
	@Override
	public int[] getLetterCount() {
	    try {
	    	//creates scanner object for file object
	        Scanner myReader = new Scanner(textFile);
	        //while there is a next line in scanner execute code within
	        while (myReader.hasNextLine()) {
	        	//get next line
	        	String sentence = (myReader.nextLine()).toLowerCase();
	        	//convert to char array
	        	char[] sentenceChars = sentence.toCharArray();
	        	//loop through for char in line
	        	for(int c = 0; c < sentenceChars.length; c++) {
	        		//check what alphabetic character char is equal to, add 1 to correct letter/index in the letterCount array
	        		if(sentenceChars[c] == 'a') { //check if letter is A
	        			letterCount[0] += 1;
	        			totalLetters++;
	        		} else if (sentenceChars[c] == 'b') { //check if letter is B
	        			letterCount[1] += 1;
	        			totalLetters++;
	        		} else if (sentenceChars[c] == 'c') { //check if letter is C
	        			letterCount[2] += 1;
	        			totalLetters++;
	        		} else if (sentenceChars[c] == 'd') { //check if letter is D
	        			letterCount[3] += 1;
	        			totalLetters++;
	        		} else if (sentenceChars[c] == 'e') { //check if letter is E
	        			letterCount[4] += 1;
	        			totalLetters++;
	        		} else if (sentenceChars[c] == 'f') { //check if letter is F
	        			letterCount[5] += 1;
	        			totalLetters++;
	        		} else if (sentenceChars[c] == 'g') { //check if letter is G
	        			letterCount[6] += 1;
	        			totalLetters++;
	        		} else if (sentenceChars[c] == 'h') { //check if letter is H
	        			letterCount[7] += 1;
	        			totalLetters++;
	        		} else if (sentenceChars[c] == 'i') { //check if letter is I
	        			letterCount[8] += 1;
	        			totalLetters++;
	        		} else if (sentenceChars[c] == 'j') { //check if letter is J
	        			letterCount[9] += 1;
	        			totalLetters++;
	        		} else if (sentenceChars[c] == 'k') { //check if letter is K
	        			letterCount[10] += 1;
	        			totalLetters++;
	        		} else if (sentenceChars[c] == 'l') { //check if letter is L
	        			letterCount[11] += 1;
	        			totalLetters++;
	        		} else if (sentenceChars[c] == 'm') { //check if letter is M
	        			letterCount[12] += 1;
	        			totalLetters++;
	        		} else if (sentenceChars[c] == 'n') { //check if letter is N
	        			letterCount[13] += 1;
	        			totalLetters++;
	        		} else if (sentenceChars[c] == 'o') { //check if letter is O
	        			letterCount[14] += 1;
	        			totalLetters++;
	        		} else if (sentenceChars[c] == 'p') { //check if letter is P
	        			letterCount[15] += 1;
	        			totalLetters++;
	        		} else if (sentenceChars[c] == 'q') { //check if letter is Q
	        			letterCount[16] += 1;
	        			totalLetters++;
	        		} else if (sentenceChars[c] == 'r') { //check if letter is R
	        			letterCount[17] += 1;
	        			totalLetters++;
	        		} else if (sentenceChars[c] == 's') { //check if letter is S
	        			letterCount[18] += 1;
	        			totalLetters++;
	        		} else if (sentenceChars[c] == 't') { //check if letter is T
	        			letterCount[19] += 1;
	        			totalLetters++;
	        		} else if (sentenceChars[c] == 'u') { //check if letter is U
	        			letterCount[20] += 1;
	        			totalLetters++;
	        		} else if (sentenceChars[c] == 'v') { //check if letter is V
	        			letterCount[21] += 1;
	        			totalLetters++;
	        		} else if (sentenceChars[c] == 'w') { //check if letter is W
	        			letterCount[22] += 1;
	        			totalLetters++;
	        		} else if (sentenceChars[c] == 'x') { //check if letter is X
	        			letterCount[23] += 1;
	        			totalLetters++;
	        		} else if (sentenceChars[c] == 'y') { //check if letter is Y
	        			letterCount[24] += 1;
	        			totalLetters++;
	        		} else if (sentenceChars[c] == 'z') { //check if letter is Z
	        			letterCount[25] += 1;
	        			totalLetters++;
	        		}        		
	        	}
	        }
	        //close connection to file
	        myReader.close();
	    } catch (FileNotFoundException e) {
	    	//if error, print error message
	        System.out.println("An error occurred.");
	    }
	    
	    //return letterCount
		return letterCount;
	}

	//gets length of all words in file
	@Override
	public int[] getWordLengthCount() {
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
	        		//move to next word and get length of that word
	        		int wordOfInterest = (sentence.next()).length();
	        		//add wordOfInterest length to tempList 
	        		tempList.add(wordOfInterest);
	        		sentence.nextLine();
	        	}
	        }
	        //close connection to file
	        myReader.close();
	        //for i in tempList, make wordLength i equal to tempList i
	        wordLength = new int[tempList.size()];
	        for(int i = 0; i <= tempList.size() - 1; i++) wordLength[i] = tempList.get(i);
	        Arrays.sort(wordLength);
	        
	    } catch (FileNotFoundException e) {
	    	//if error, print error message
	        System.out.println("An error occurred.");
	    }		
		
		return wordLength;
	}

	//gets average length of a word in the file
	@Override
	public double getAverageWordLength() {
		//averageWordLength equals totalLetters divided by wordCount
		averageWordLength = totalLetters / getWordCount(); //WHY IS THIS NOT GIVING THE PROPER AVERAGE?? Even though this has errors, it's not giving the proper average for the errors
		System.out.println(getWordCount()); //word count is way too high here but for some reason is normal in the toString method
		return averageWordLength;
	}
	
	public String toString(){
		getLetterCount();
		getWordLengthCount();
		int lengths = lengthList.size() - 1;
		//for item in wordLength array, add item to lengthList, find index of that item and add 1 to corresponding index in occurrenceList.
		//If item already in lengthList, find index of that item and add 1 to corresponding index in occurrenceList
		//LOTS AND LOTS OF ISSUES HERE
		/*
		for(int i = 0; i <= tempList.size() - 1; i++) {
			if(lengthList.contains(wordLength[i])) {
				//gets index of the current word length
				int index = lengthList.indexOf(wordLength[i]);
				//adds 1 to the count of the occurrences of the current word length
				int newCountVal = (occurrenceList.get(index))+1; //ERRORS START HERE
				//sets old count value to new count value
				occurrenceList.set(index, newCountVal);
			} else {
				//adds word length to lengthList
				lengthList.add(wordLength[i]);
				//gets index of the current word length
				int index = lengthList.indexOf(wordLength[i]);
				//adds 1 to the count of the occurrences of the current word length
				int newCountVal = (occurrenceList.get(index))+1; //SAME ERROR DOWN HERE
				//sets old count value to new count value
				occurrenceList.set(index, newCountVal);
			}
		}
		//string containing all data
		String lengthStats = "length  frequency\n------  ---------\n";
		for(int i = 0; i <= lengths; i++) {
			//for item in lengthList, add that item and it's occurrences to lengthStats
			lengthStats += lengthList.get(i) + "\t" + occurrenceList.get(i);
		}
		*/
			
		return "==========================================================\n" + getLineCount() + " Lines" + "\n" + getWordCount() + " Words" + "\n" + getCharCount() + " Chars" + "\n" + "------------------------------\n" + "a = " + letterCount[0] + "\t\tn = " + letterCount[13] + "\nb = " + letterCount[1] + "\t\to = " + letterCount[14] + "\nc = " + letterCount[2] + "\t\tp = " + letterCount[15] + "\nd = " + letterCount[3] + "\t\tq = " + letterCount[16] + "\ne = " + letterCount[4] + "\t\tr = " + letterCount[17] + "\nf = " + letterCount[5] + "\t\ts = " + letterCount[18] + "\ng = " + letterCount[6] + "\t\tt = " + letterCount[19] + "\nh = " + letterCount[7] + "\t\tu = " + letterCount[20] + "\ni = " + letterCount[8] + "\t\tv = " + letterCount[21] + "\nj = " + letterCount[9] + "\t\tw = " + letterCount[22] + "\nk = " + letterCount[10] + "\t\tx = " + letterCount[23] + "\nl = " + letterCount[11] + "\t\ty = " + letterCount[24] + "\nm = " + letterCount[12] + "\t\tz = " + letterCount[25] + "\n------------------------------\n" /*+ lengthStats */ + "\nAverage word length = " + getAverageWordLength() + "\n==========================================================";
	}
}
