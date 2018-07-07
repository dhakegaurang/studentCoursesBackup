package studentCoursesBackup.driver;

import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.InputProcessor;
import studentCoursesBackup.util.Results;
import studentCoursesBackup.util.TreeBuilder;

public class Driver {

	public static void main(String[] args) {

		String inputPath = "input/input_1.txt";
		String outputPath = "output.txt";
		
		Results resultObj = new Results(outputPath);
		TreeBuilder treeBuilderObj = new TreeBuilder(resultObj);
		InputProcessor inputProcessorObj = new InputProcessor(treeBuilderObj);
		FileProcessor fileProcessorObj = new FileProcessor(inputPath,inputProcessorObj);
		fileProcessorObj.readLine();
		treeBuilderObj.printNodes(resultObj, treeBuilderObj.getOriginalNode());
		System.out.println(resultObj.getResultStr());
	}

}
