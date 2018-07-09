package studentCoursesBackup.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import studentCoursesBackup.util.MyLogger.DebugLevel;

public class Results implements FileDisplayInterface,StdoutDisplayInterface{
	private String resultStr;
	private String outputFilePath;
	private DebugLevel debugLevel;
	
	public Results(String outputFilePath) {
		this.debugLevel = debugLevel.RESULTS;
		resultStr = "";	
		this.outputFilePath = outputFilePath;
	}
	
	@Override
	public void writeToStdout(String s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeToFile(String s) {
		MyLogger.writeMessage("in Results writeToFile method", debugLevel);
		try {
			Files.write(Paths.get(outputFilePath), s.getBytes());
		}
		catch(IOException e) {
			System.err.println("Exception: writing to output.txt");
			System.err.println("Exiting...");
			System.exit(0);
		}
		
	}
	
	public void storeNewResult(String newResult) {
		MyLogger.writeMessage("in Results storeNewResult method", debugLevel);
		resultStr += newResult;
	}

	@Override
	public String toString() {
		return resultStr;
	}

	public String getResultStr() {
		return resultStr;
	}

	public void setResultStr(String resultStr) {
		this.resultStr = resultStr;
	}
	
}
