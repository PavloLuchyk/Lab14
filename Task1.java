package lab14;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;


public class Task1 {
	public static long numberOfWords(String filename) throws IOException {
		if (filename == null) {
			throw new NullPointerException("Filename cannot be null");
		}
		long wordCount=0;
		try(BufferedReader br = new BufferedReader(new FileReader(filename))){
			String string, fileContent="";
			while((string = br.readLine()) != null) {
				fileContent += string +" ";
			}
			String[] words = fileContent.split("\\s+");
			wordCount = words.length;
		} 
		return wordCount;
	}
	
	public static void main(String[] args) {
		doTask("file.txt");		
	}
	
	public static void doTask(String filename) {
		try {
			System.out.println("Number of words in file \"" + filename + "\": " + numberOfWords(filename));
		} catch(Exception e) {
			System.err.println("Exception! " + e.getMessage());
		}
	}
}
