package studentCoursesBackup.util;

public class InputProcessor {
	private TreeBuilder treeBuilderObj;
	
	public InputProcessor(TreeBuilder treeBuilderObj) {
		this.treeBuilderObj = treeBuilderObj;
	}

	public void parseLine(String[] dataArray, String myOperation) {
			
		try {
			int bNumber = Integer.parseInt(dataArray[0]);
			String subject = dataArray[1];
			if("insert".equals(myOperation)) {
				treeBuilderObj.insert(bNumber, subject);
			}
			else if("delete".equals(myOperation)) {
				treeBuilderObj.delete(bNumber, subject);
			}
			
		}
		catch(NumberFormatException e) {
			System.err.println("Exception: Make sure you have entered bNumber as integer and subject as character");
			System.err.println("Exiting...");
			System.exit(0);
		}
		
	}

}