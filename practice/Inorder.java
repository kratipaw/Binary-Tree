package practice;

import java.util.Stack;

public class Inorder {

	public static void main(String[] args) {

		Node node = new Node(1);
		node.left = new Node(2);
		node.right = new Node(3);
		node.left.left = new Node(4);
		node.left.right = new Node(5);
		node.right.left = new Node(6);
		node.right.right = new Node(7);
		
		System.out.println("Inorder Tree traversal is : ");
		
		inorder_recursive(node);
		System.out.println();
		
		inorder_iterative(node);
	}
	
	//Using recursion, TC = O(n), SC = O(1) not considering stack call because of recursion
	private static void inorder_recursive(Node node) {
		
		if(node != null) {
			
			inorder_recursive(node.left);
			
			System.out.print(node.data + " ");
			
			inorder_recursive(node.right);
			
		}
		
	}
	
	// w/o recursion, using stack, TC = O(n), SC = O(n)  
	private static void inorder_iterative(Node node) {
		
		Stack<Node> stack = new Stack<>();
		
		Node curr = node;
		
		while(curr != null || !stack.isEmpty()) {
		
			while(curr != null) {
				stack.add(curr);
				curr = curr.left;
			}
			
			curr = stack.pop();
			
			System.out.print(curr.data + " ");
			
			curr = curr.right;
			
		}
		
		System.out.println();
	}

	// w/o recursion, w/o using stack,  
	private static void inorder_Morris(Node node) {
		//Morris traversal : need to implement.
		//https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
	}
}
