package practice;

import java.util.Stack;

public class Preorder {

	public static void main(String[] args) {
		
		Node node = new Node(1);
		node.left = new Node(2);
		node.right = new Node(3);
		node.left.left = new Node(4);
		node.left.right = new Node(5);
		node.right.left = new Node(6);
		node.right.right = new Node(7);
		
		System.out.println("Preorder Tree traversal is : ");
		
		preorder_recursive(node);
		System.out.println();
		
		preorder_iterative(node);
	}
	
	//Recursion, TC = O(n), SC = O(1) excluding stack call
	private static void preorder_recursive(Node node) {
		
		if(node == null)
			return;
		
		System.out.print(node.data + " ");
		
		preorder_recursive(node.left);
		
		preorder_recursive(node.right);
	}
	
	//using stack, TC = O(n), SC = O(n)
	private static void preorder_iterative(Node node) {
		
		if(node == null)
			return;
		
		Stack<Node> stack = new Stack<>();
		
		stack.add(node);
		
		while(!stack.isEmpty()) {
			
			Node curr = stack.pop();
			System.out.print(curr.data + " ");
			
			if(curr.right != null)
				stack.add(curr.right);
			
			if(curr.left != null)
				stack.add(curr.left);
		}
	}
	
	private static void preorder_Morris(Node node) {
		//Morris traversal : need to implement.
		//https://www.geeksforgeeks.org/morris-traversal-for-preorder/
	}

	
}
