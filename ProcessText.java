package fileSearcher;

import java.io.*;

public class ProcessText {
	//main method
	public static void main(String[] args) throws FileNotFoundException {
		for(String arg : args){
			//gets current working directory as a string
			String currentDir = System.getProperty("user.dir") + "/src/fileSearcher/";
			//creates a text file object out of the given file name(s) and current working directory 
			File textFile = new File(currentDir + arg);
			
			//checks if file object is actually a file
			if(textFile.exists() && textFile.isFile()) {
				//creates new TextStatistics object with textFile object
				TextStatistics2 info = new TextStatistics2(textFile);
				//calls toString method and prints out TextStatistics object
				System.out.println(info.toString());
				
			}else{
				//if error with file not being found/detected, print an error message
				System.out.println("Try entering a valid text file ending in '.txt'");
			}
		}
	}
}
