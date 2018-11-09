package practice;

import java.util.LinkedList;
import java.util.Queue;

public class IdenticalTrees {

	public static void main(String[] args) {
		   
        Node A = new Node(1); 
        A.left = new Node(2); 
        A.right = new Node(3); 
        A.left.left = new Node(4); 
        A.left.right = new Node(5); 
   
        Node B = new Node(1); 
        B.left = new Node(2); 
        B.right = new Node(3); 
        B.left.left = new Node(4); 
        B.left.right = new Node(5); 
        
        System.out.println(ifIdenticalTrees_recursively(A, B));
        
        System.out.println(ifIdentical_iterative(A, B));
	}

	private static boolean ifIdenticalTrees_recursively(Node A, Node B) {
		if(A == null && B == null)
		return true;
		if(A != null && B != null)
		return (A.data == B.data) && ifIdenticalTrees_recursively(A.left, B.left) && ifIdenticalTrees_recursively(A.right, B.right);
		return false;
	}
	
	private static boolean ifIdentical_iterative(Node A, Node B) {
		
		if(A == null && B == null)
			return true;
		
		Queue<Node> quA = new LinkedList<Node>();
		
		Queue<Node> quB = new LinkedList<Node>();
		
		quA.add(A);
		quB.add(B);
		
		while(!quA.isEmpty() && !quB.isEmpty()) {
			
			Node tempA = quA.poll();
			Node tempB = quB.poll();
			
			if(tempA.data != tempB.data) 
				return false;
			
			if(tempA.left != null && tempB.left != null) {
				quA.add(tempA.left);
				quB.add(tempB.left);
			}
			else if((tempA.left == null && tempB.left != null) || (tempA.left != null && tempB.left == null))
				return false;
		
			if(tempA.right != null && tempB.right != null) {
				quA.add(tempA.right);
				quB.add(tempB.right);
			}
			else if((tempA.left == null && tempB.left != null) || (tempA.left != null && tempB.left == null))
				return false;
		}
		
		return true;
	}
	
}
