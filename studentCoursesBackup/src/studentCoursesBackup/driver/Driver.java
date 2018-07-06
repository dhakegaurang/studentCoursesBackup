package studentCoursesBackup.driver;

import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.InputProcessor;

public class Driver {

	public static void main(String[] args) {

		String inputPath = "input/input_1.txt";
		String outputPath = "output.txt";
		
		InputProcessor inputProcessorObj = new InputProcessor();
		FileProcessor fileProcessorObj = new FileProcessor(inputPath,inputProcessorObj);
		fileProcessorObj.readLine();
		
	}

}
