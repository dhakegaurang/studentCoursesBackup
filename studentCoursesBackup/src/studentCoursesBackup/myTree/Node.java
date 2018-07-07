package studentCoursesBackup.myTree;

import java.util.ArrayList;

import studentCoursesBackup.util.Results;

public class Node implements ObserverI,SubjectI{
	private int bNumber;
	private Node left;
	private Node right;	
	private ArrayList<String> courses;
    public enum OPERATION {
		INSERT, DELETE
	}
    
	public Node(int bNumber){
		this.bNumber = bNumber;
		left = null;
		right = null;
		courses = new ArrayList<>();
	}
	
	@Override
	public void registerObserver(ObserverI o) {
		
		
	}

	@Override
	public void removeObserver(ObserverI o) {
		
		
	}

	@Override
	public void notifyObservers(OPERATION operation) {
		
		
	}

	@Override
	public void update(int bNumber, String courseName, OPERATION operation) {
		
		
	}
	
	public void printData(Results result) {
		String resultStr = "\nBNumber:"+bNumber;
		resultStr += "\nCourses:";
		for(String course : courses) {
			resultStr += course+" ";
		}
		resultStr += "\n";
		result.storeNewResult(resultStr);
	}
	
	public int getbNumber() {
		return bNumber;
	}
	
	public void setbNumber(int bNumber) {
		this.bNumber = bNumber;
	}
	
	public Node getLeft() {
		return left;
	}
	
	public void setLeft(Node left) {
		this.left = left;
	}
	
	public Node getRight() {
		return right;
	}
	
	public void setRight(Node right) {
		this.right = right;
	}

	public ArrayList<String> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<String> courses) {
		this.courses = courses;
	}
	
	
}
