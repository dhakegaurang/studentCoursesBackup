package studentCoursesBackup.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import studentCoursesBackup.util.MyLogger.DebugLevel;

public class FileProcessor {
	private String inputFilePath;
	private BufferedReader bReaderObj;
	private InputProcessor inputProcessorObj;
	private String myOperation;
	private DebugLevel debugLevel;
	
	public FileProcessor(String inputFilePath, InputProcessor inputProcessorObj, String myOperation) {
		this.debugLevel = debugLevel.FILE_PROCESSOR;
		MyLogger.writeMessage("in fileprocessor constructor", debugLevel);
		this.inputFilePath = inputFilePath;
		this.inputProcessorObj = inputProcessorObj;
		this.myOperation = myOperation;
	}
	
	public void readLine() {
		MyLogger.writeMessage("in fileprocessor readline", debugLevel);
		try{
			bReaderObj = new BufferedReader(new FileReader(inputFilePath));
		    String line;
		    while ((line = bReaderObj.readLine()) != null) {
		       String[] dataArray = line.split(":");
		       inputProcessorObj.parseLine(dataArray,myOperation);
		    }
		}
		catch(IOException  e) { //handling in case of bufferedReader goes wrong
			System.err.println("Exception: while reading input file");
			System.out.println("Exiting...");
			System.exit(0);
		}
	}
	
}
