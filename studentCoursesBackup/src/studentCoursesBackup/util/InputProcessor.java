package studentCoursesBackup.util;

public class InputProcessor {

	public void parseLine(String[] dataArray) {
		
		try {
			int bNumber = Integer.parseInt(dataArray[0]);
			char subject = '\0';
			if(dataArray[1].length() > 1) {
				throw new NumberFormatException();
			}
			else {
				subject = dataArray[1].charAt(0);
			}
			System.out.println(bNumber+" "+subject); 
		}
		catch(NumberFormatException e) {
			System.err.println("Exception: Make sure you have entered bNumber as integer and subject as character");
			System.err.println("Exiting...");
			System.exit(0);
		}
		
	}

}
