package studentCoursesBackup.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor {
	private String inputFilePath;
	private BufferedReader bReaderObj;
	private InputProcessor inputProcessorObj;
	
	public FileProcessor(String inputFilePath, InputProcessor inputProcessorObj) {
		this.inputFilePath = inputFilePath;
		this.inputProcessorObj = inputProcessorObj;
	}
	
	public void readLine() {
		try{
			bReaderObj = new BufferedReader(new FileReader(inputFilePath));
		    String line;
		    while ((line = bReaderObj.readLine()) != null) {
		       String[] dataArray = line.split(":");
		       inputProcessorObj.parseLine(dataArray);
		    }
		}
		catch(IOException  e) { //handling in case of bufferedReader goes wrong
			System.err.println("Exception: while reading input file");
			System.out.println("Exiting...");
			System.exit(0);
		}
	}
	
}
