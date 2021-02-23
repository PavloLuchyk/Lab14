package lab14;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;

public class Task2 {
	public static void unsplit(String sourcePrefix,String destination) throws IOException {
		int i = 0;
		char[] cbuf = new char[512];
		try(FileWriter wr = new FileWriter(destination)) {
				while (Files.exists(Paths.get(sourcePrefix+"."+String.format("%03d",i)))) {
					wr.append(sourcePrefix+"."+String.format("%03d",i)+"\n");
					try (FileReader fis = new FileReader(sourcePrefix+"."+String.format("%03d",i))){
						int readed;
						while ((readed = fis.read(cbuf)) != -1) {
							wr.append(new String(cbuf),0,readed);
						}
					}
					wr.append("\n\n");
					i++;
				}
				wr.flush();
		}		
	}
	
	public static void main(String[] args) {
		doTask("file","1");
	}
	
	public static void doTask(String sourcePrefix, String destination) {
		try {
			unsplit(sourcePrefix,destination);
		} catch(Exception e) {
			System.err.println("Exception! " + e.getMessage());
		}
	}
	
	
	
	

}
