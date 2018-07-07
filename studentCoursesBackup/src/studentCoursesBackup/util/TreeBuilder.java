package studentCoursesBackup.util;

import java.util.ArrayList;

import studentCoursesBackup.myTree.Node;
// https://algorithms.tutorialhorizon.com/binary-search-tree-complete-implementation/

public class TreeBuilder {
	private Node originalNode;
	private Results resultObj;
	
	public TreeBuilder(Results resultObj){
		this.originalNode = null;
		this.resultObj = resultObj;
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
			if(!tempList.contains(courseName))
				tempList.add(courseName);
			return;
		}
		
		Node newNode = new Node(id);
		if(originalNode==null){
			originalNode = newNode;
			return;
		}
		Node current = originalNode;
		Node parent = null;
		while(true){
			parent = current;
			if(id < current.getbNumber()){				
				current = current.getLeft();
				if(current==null){
					parent.setLeft(newNode);
					return;
				}
			}else{
				current = current.getRight();
				if(current==null){
					parent.setRight(newNode);
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

	public Results getResultObj() {
		return resultObj;
	}

	public void setResultObj(Results resultObj) {
		this.resultObj = resultObj;
	}
	
}
