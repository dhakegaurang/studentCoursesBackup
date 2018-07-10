package studentCoursesBackup.driver;

import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.InputProcessor;
import studentCoursesBackup.util.MyLogger;
import studentCoursesBackup.util.Results;
import studentCoursesBackup.util.TreeBuilder;

public class Driver {

	public static void main(String[] args) {

		String inputPath = "";
		String deletePath = "";
		String outputPath1 = "";
		String outputPath2 = "";
		String outputPath3 = "";
		int debugLevel = -1;
		
		try {

			if(args[0] != null && "".equals(args[0])) {
				inputPath = args[0];
			}
			else {
				throw new IllegalArgumentException("Exception: Please enter proper input file path!!");
			}
			if(args[1] != null && "".equals(args[1])) {
				deletePath = args[1];
			}
			else {
				throw new IllegalArgumentException("Exception: Please enter proper delete file path!!");
			}
			if(args[2] != null && "".equals(args[2])) {
				outputPath1 = args[2];
			}
			else {
				throw new IllegalArgumentException("Exception: Please enter proper output1 file path!!");
			}
			if(args[3] != null && "".equals(args[3])) {
				outputPath2 = args[3];
			}
			else {
				throw new IllegalArgumentException("Exception: Please enter proper output2 file path!!");
			}
			if(args[4] != null && "".equals(args[4])) {
				outputPath3 = args[4];
			}
			else {
				throw new IllegalArgumentException("Exception: Please enter proper output3 file path!!");
			}
			if(args[5] != null && "".equals(args[5])) {
				debugLevel = Integer.parseInt(args[5]);
			}
			else {
				debugLevel = 1;
			}
			
			Results resultObj1 = new Results(outputPath1);
			Results resultObj2 = new Results(outputPath2);
			Results resultObj3 = new Results(outputPath3);
			
			MyLogger.setDebugValue(debugLevel);
			
			TreeBuilder treeBuilderObj = new TreeBuilder(resultObj1,resultObj2,resultObj3);
			
			InputProcessor inputProcessorObj = new InputProcessor(treeBuilderObj);
			
			FileProcessor fileProcessorObj = new FileProcessor(inputPath,inputProcessorObj,"insert");
			fileProcessorObj.readLine();
			
			fileProcessorObj = new FileProcessor(deletePath,inputProcessorObj,"delete");
			fileProcessorObj.readLine();
			
			treeBuilderObj.printNodes(resultObj1, treeBuilderObj.getOriginalNode());
			treeBuilderObj.printNodes(resultObj2, treeBuilderObj.getObserverNode1());
			treeBuilderObj.printNodes(resultObj3, treeBuilderObj.getObserverNode2());
			
			resultObj1.writeToFile(resultObj1.getResultStr());
			resultObj2.writeToFile(resultObj2.getResultStr());
			resultObj3.writeToFile(resultObj3.getResultStr());
		}
		catch(IllegalArgumentException e) {
			System.err.println(e.getMessage());
			System.err.println("Exiting...");
			System.exit(0);
 		}
		catch(Exception e) {
			System.err.println("Exception: in main class");
			System.err.println("Exiting...");
			System.exit(0);
		}
		
	}
		
}
