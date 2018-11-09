package practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderTraversal {

	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		
		System.out.println("Level Order");
		levelOrder(root);
		
		System.out.println("Level order in reverse : ");
		reverse(root);
		
		System.out.println("Reverse Level Order : ");
		reverseLevelOrder(root);
		
		System.out.println("Level order in Spiral : ");
		spiral(root);
		
		System.out.println("Level order traversal in a way that nodes of all levels are printed in separate lines : ");
		levelOrderLineByLine(root);
		
	}

	private static void levelOrder(Node root) {
		if(root == null)
			return;
		
		Queue<Node> qu = new LinkedList<>();
		qu.add(root);
		
		while(!qu.isEmpty()) {
			Node temp = qu.poll();
			System.out.print(temp.data + " ");
			
			if(temp.left!=null)
				qu.add(temp.left);
			
			if(temp.right!=null)
				qu.add(temp.right);
		}
		System.out.println();
	}
	
	private static void reverse(Node root) {
		if(root == null)
			return;
		
		Stack<Node> st = new Stack<>();
		
		Queue<Node> qu = new LinkedList<>();
		qu.add(root);
		
		while(!qu.isEmpty()) {
			Node temp = qu.poll();
			st.add(temp);
			
			if(temp.left!=null)
				qu.add(temp.left);
			if(temp.right!=null)
				qu.add(temp.right);
		}
		
		while(!st.isEmpty())
			System.out.print(st.pop().data + " ");
		
		System.out.println();
	}
	
	private static void reverseLevelOrder(Node root) {
		if(root==null)
			return;
		
		Stack<Node> st = new Stack<>();
		
		Queue<Node> qu = new LinkedList<>();
		qu.add(root);
		
		while(!qu.isEmpty()) {
			Node temp = qu.poll();
			st.add(temp);
			
			if(temp.right!=null)
				qu.add(temp.right);
			if(temp.left!=null)
				qu.add(temp.left);
		}
		
		while(!st.isEmpty())
			System.out.print(st.pop().data + " ");
		
		System.out.println();
	}
	
	private static void spiral(Node root) {
		if(root == null)
			return;
		
		Stack<Node> st1 = new Stack<>();
		
		Stack<Node> st2 = new Stack<>();
		st1.add(root);
		
		while(!st1.isEmpty() || !st2.isEmpty()) {
			while(!st1.isEmpty()) {
				Node temp = st1.pop();
				System.out.print(temp.data + " ");
				
				if(temp.right!=null)
					st2.add(temp.right);
				if(temp.left!=null)
					st2.add(temp.left);
			}
			
			while(!st2.isEmpty()) {
				Node temp = st2.pop();
				System.out.print(temp.data + " ");
				
				if(temp.left!=null)
					st1.add(temp.left);
				if(temp.right!=null)
					st1.add(temp.right);
			}
		}
		System.out.println();
	}
	
	private static void levelOrderLineByLine(Node root) {
		if(root== null)
			return;
		
		Queue<Node> qu = new LinkedList<>();
		qu.add(root);
		
		while(!qu.isEmpty()) {
			int nodeCount = qu.size();
			if(nodeCount == 0)
				break;
			while(nodeCount > 0) {
				Node temp = qu.poll();
				System.out.print(temp.data + " ");
				
				if(temp.left != null)
					qu.add(temp.left);
				if(temp.right!=null)
					qu.add(temp.right);
				
				nodeCount--;
			}
			System.out.println();
		}
	}
}

