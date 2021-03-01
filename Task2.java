package lab14;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;

public class Task2 {
	public static void unsplit(String sourcePrefix,String destination) throws IOException {
		int readed, i = 0;
		char[] cbuf = new char[512];
		try(FileWriter fw = new FileWriter(destination)) {
				while (Files.exists(Paths.get(sourcePrefix+"."+String.format("%03d",i)))) {
					fw.append(sourcePrefix+"."+String.format("%03d",i)+"\n");
					try (FileReader fr = new FileReader(sourcePrefix+"."+String.format("%03d",i))){
						while ((readed = fr.read(cbuf)) != -1) {
							fw.append(new String(cbuf),0,readed);
						}
					}
					fw.append("\n\n");
					i++;
				}
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
