package studentCoursesBackup.myTree;

import java.util.ArrayList;

import studentCoursesBackup.util.Results;

public class Node implements ObserverI,SubjectI,Cloneable{
	private int bNumber;
	private Node left;
	private Node right;	
	private ArrayList<String> courses;
	private ArrayList<ObserverI> observers;
	private String courseName;
    public enum OPERATION {
		INSERT, DELETE
	}
    
	public Node(int bNumber,String courseName){
		this.bNumber = bNumber;
		left = null;
		right = null;
		courses = new ArrayList<>();
		observers = new ArrayList<>();
		courses.add(courseName);
	}
	
	@Override
	public void registerObserver(ObserverI o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(ObserverI o) {
		observers.remove(o);
	}

	@Override
	public void notifyObservers(OPERATION operation) {
		for(ObserverI observer : observers) {
			observer.update(bNumber, courseName, operation);
		}
		
	}

	@Override
	public void update(int bNumber, String courseName, OPERATION operation) {
		
		for(ObserverI observer : observers) {
			Node tempNode = (Node) observer;
			switch(operation) {
			case INSERT:
				tempNode.getCourses().add(courseName);
				break;
			case DELETE:
				tempNode.getCourses().remove(courseName);
				break;
			}
		}
	}
	
	public void printData(Results result) {
		String resultStr = "BNumber:"+bNumber;
		resultStr += "\nCourses:";
		for(String course : courses) {
			resultStr += course+" ";
		}
		resultStr += "\n\n";
		result.storeNewResult(resultStr);
	}
	
	public Node clone() {
		Node node = null;
		try {
			node = (Node) super.clone();
		}
		catch(CloneNotSupportedException e) {
			System.err.println("Exception: Not able to clone super class");
			System.err.println("Exiting...");
			System.exit(0);
		}
		return node;
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

	public ArrayList<ObserverI> getObservers() {
		return observers;
	}

	public void setObservers(ArrayList<ObserverI> observers) {
		this.observers = observers;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	
}
