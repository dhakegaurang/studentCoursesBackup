package studentCoursesBackup.driver;

import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.InputProcessor;
import studentCoursesBackup.util.Results;
import studentCoursesBackup.util.TreeBuilder;

public class Driver {

	public static void main(String[] args) {

		String inputPath = "input/input_1.txt";
		String outputPath1 = "output1.txt";
		String outputPath2 = "output2.txt";
		String outputPath3 = "output3.txt";
		
		Results resultObj1 = new Results(outputPath1);
		Results resultObj2 = new Results(outputPath2);
		Results resultObj3 = new Results(outputPath3);
		TreeBuilder treeBuilderObj = new TreeBuilder(resultObj1,resultObj2,resultObj3);
		InputProcessor inputProcessorObj = new InputProcessor(treeBuilderObj);
		FileProcessor fileProcessorObj = new FileProcessor(inputPath,inputProcessorObj);
		fileProcessorObj.readLine();
		treeBuilderObj.printNodes(resultObj1, treeBuilderObj.getOriginalNode());
		treeBuilderObj.printNodes(resultObj2, treeBuilderObj.getObserverNode1());
		treeBuilderObj.printNodes(resultObj3, treeBuilderObj.getObserverNode2());
		//resultObj1.writeToFile(resultObj1.getResultStr());
		System.out.println("----------Original------------");
		System.out.println(resultObj1.getResultStr());
		System.out.println("");
		System.out.println("----------Backup1------------");
		System.out.println(resultObj2.getResultStr());
		System.out.println("");
		System.out.println("----------Backup2------------");
		System.out.println(resultObj3.getResultStr());
	}

}
