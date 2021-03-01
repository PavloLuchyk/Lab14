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
			String string,str="";
			while((string = br.readLine()) != null) {
				str += string +" ";
			}
			String[] words = str.split("\\s+");
			wordCount = words.length;
		} 
		return wordCount;
	}
	
	public static void main(String[] args) {
		printResults("file.txt");		
	}
	
	public static void printResults(String filename) {
		try {
			System.out.println(numberOfWords(filename));
		} catch(Exception e) {
			System.err.println("Exception! " + e.getMessage());
		}
	}
}
