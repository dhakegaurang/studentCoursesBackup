package studentCoursesBackup.myTree;

public class Node {
	private int bNumber;
	private Node left;
	private Node right;	
	
	public Node(int bNumber){
		this.bNumber = bNumber;
		left = null;
		right = null;
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
	
	
}
