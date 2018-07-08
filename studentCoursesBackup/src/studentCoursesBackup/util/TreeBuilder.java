package studentCoursesBackup.util;

import java.util.ArrayList;

import studentCoursesBackup.myTree.Node;
// https://algorithms.tutorialhorizon.com/binary-search-tree-complete-implementation/
import studentCoursesBackup.myTree.Node.OPERATION;
import studentCoursesBackup.myTree.SubjectI;

public class TreeBuilder {
	private Node originalNode;
	private Node observerNode1, observerNode2;
	private Results resultObj1;
	private Results resultObj2;
	private Results resultObj3;
	
	public TreeBuilder(Results resultObj, Results resultObj2, Results resultObj3){
		this.originalNode = null;
		this.observerNode1 = null;
		this.observerNode2 = null;
		this.resultObj1 = resultObj1;
		this.resultObj2 = resultObj2;
		this.resultObj3 = resultObj3;
	}
		
	public boolean delete(int id){
		Node parent = originalNode;
		Node current = originalNode;
		boolean isLeftChild = false;
		while(current.getbNumber()!=id){
			parent = current;
			if(current.getbNumber() > id){
				isLeftChild = true;
				current = current.getLeft();
			}else{
				isLeftChild = false;
				current = current.getRight();
			}
			if(current ==null){
				return false;
			}
		}
		//if i am here that means we have found the node
		//Case 1: if node to be deleted has no children
		if(current.getLeft()==null && current.getRight()==null){
			if(current==originalNode){
				originalNode = null;
			}
			if(isLeftChild ==true){
				parent.setLeft(null);
			}else{
				parent.setRight(null);
			}
		}
		//Case 2 : if node to be deleted has only one child
		else if(current.getRight()==null){
			if(current==originalNode){	
				originalNode  =current.getLeft();
			}else if(isLeftChild){
				parent.setLeft(current.getLeft()); 
			}else{
				parent.setRight(current.getLeft()); 
			}
		}
		else if(current.getLeft()==null){
			if(current==originalNode){
				originalNode = current.getRight();
			}else if(isLeftChild){
				parent.setLeft(current.getRight()); 
			}else{
				parent.setRight(current.getRight()); 
			}
		}else if(current.getLeft()!=null && current.getRight()!=null){
			
			//now we have found the minimum element in the right sub tree
			Node successor	 = getSuccessor(current);
			if(current==originalNode){
				originalNode = successor;
			}else if(isLeftChild){
				parent.setLeft(successor);	
			}else{
				parent.setRight(successor); 
			}			
			successor.setLeft(current.getLeft()); 
		}		
		return true;		
	}
	
	public Node getSuccessor(Node deleleNode){
		Node successsor = null;
		Node successsorParent = null;
		Node current = deleleNode.getRight();
		while(current!=null){
			successsorParent = successsor;
			successsor = current;
			current = current.getLeft();
		}
		//check if successor has the right child, it cannot have left child for sure
		// if it does have the right child, add it to the left of successorParent.
//		successsorParent
		if(successsor!=deleleNode.getRight()){
			successsorParent.setLeft(successsor.getRight());
			successsor.setRight(deleleNode.getRight());
		}
		return successsor;
	}

	public boolean search(int id){
		Node current = originalNode;
		while(current!=null){
			if(current.getbNumber()==id){
				return true;
			}else if(current.getbNumber() > id){
				current = current.getLeft();
			}else{
				current = current.getRight();
			}
		}
		return false;
	}
	
	public Node searchNode(int id){
		Node current = originalNode;
		while(current!=null){
			if(current.getbNumber()==id){
				return current;
			}else if(current.getbNumber() > id){
				current = current.getLeft();
			}else{
				current = current.getRight();
			}
		}
		return null;	
	}
	
	public void insert(int id, String courseName){
		
		Node existingNode = searchNode(id);
		if(existingNode != null) {
			ArrayList<String> tempList = existingNode.getCourses();
			if(!tempList.contains(courseName)) {
				tempList.add(courseName);
			}
			return;
		}
		
		Node newNode = new Node(id,courseName);
		if(originalNode==null){
			originalNode = newNode;
			observerNode1 = originalNode.clone();
			observerNode2 = originalNode.clone();
			originalNode.setCourseName(courseName);
			originalNode.registerObserver(observerNode1);
			originalNode.registerObserver(observerNode2);
			return;
		}
		Node current = originalNode;
		Node currentObserver1 = observerNode1;
		Node currentObserver2 = observerNode2;
		Node parent = null;
		Node parentObserver1 = null;
		Node parentObserver2 = null;
		while(true){
			parent = current;
			parentObserver1 = currentObserver1;
			parentObserver2 = currentObserver2;
			if(id < current.getbNumber()){				
				current = current.getLeft();
				currentObserver1 = currentObserver1.getLeft();
				currentObserver2 = currentObserver2.getLeft();
				if(current==null){
					parent.setLeft(newNode);
					parentObserver1.setLeft(parent.getLeft().clone());
					parentObserver2.setLeft(parent.getLeft().clone());
					parent.getLeft().registerObserver(parentObserver1.getLeft());
					parent.getLeft().registerObserver(parentObserver2.getLeft());
					return;
				}
			}else{
				current = current.getRight();
				currentObserver1 = currentObserver1.getRight();
				currentObserver2 = currentObserver2.getRight();
				if(current==null){
					parent.setRight(newNode);
					parentObserver1.setRight(parent.getRight().clone());
					parentObserver2.setRight(parent.getRight().clone());
					parent.getRight().registerObserver(parentObserver1.getRight());
					parent.getRight().registerObserver(parentObserver2.getRight());
					return;
				}
			}
		}
	}
	
	public void printNodes(Results result, Node root){
		if(root!=null){
			printNodes(result,root.getLeft());
			root.printData(result);
			printNodes(result,root.getRight());	
		}
	}

	public Node getOriginalNode() {
		return originalNode;
	}

	public void setOriginalNode(Node originalNode) {
		this.originalNode = originalNode;
	}

	public Results getResultObj1() {
		return resultObj1;
	}

	public void setResultObj1(Results resultObj1) {
		this.resultObj1 = resultObj1;
	}

	public Results getResultObj2() {
		return resultObj2;
	}

	public void setResultObj2(Results resultObj2) {
		this.resultObj2 = resultObj2;
	}

	public Results getResultObj3() {
		return resultObj3;
	}

	public void setResultObj3(Results resultObj3) {
		this.resultObj3 = resultObj3;
	}

	public Node getObserverNode1() {
		return observerNode1;
	}

	public void setObserverNode1(Node observerNode1) {
		this.observerNode1 = observerNode1;
	}

	public Node getObserverNode2() {
		return observerNode2;
	}

	public void setObserverNode2(Node observerNode2) {
		this.observerNode2 = observerNode2;
	}

	
	
}
