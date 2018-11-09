package practice;

import java.util.Stack;

public class MirrorImage {

	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(2);
		root.left.left = new Node(4);
		root.right.right = new Node(4);
		
		System.out.println(isMirrorImageOfItself(root));
		
		Node root2 = new Node(1);
		root2.left = new Node(2);
		root2.right = new Node(2);
		root2.left.left = new Node(4);
		root2.right.right = new Node(4);
		
		System.out.println(areMirror_recur(root, root2));
		
		System.out.println(areMirror_iterative(root, root2));
	}

	//Symetric Tree is mirror image of itself
	private static boolean isMirrorImageOfItself(Node root) {
		
		return areMirror_recur(root, root);
	
	}
	
	private static boolean areMirror_recur(Node A, Node B) {
		
		if(A == null && B == null)
			return true;
		
		if(A == null || B == null)
			return false;
		
		return A.data == B.data && areMirror_recur(A.left, B.right) && areMirror_recur(A.right, B.left);
	}
	
	//iterative inorder traversal of one tree and iterative reverse inorder traversal of the other tree in parallel.
	private static boolean areMirror_iterative(Node A, Node B) {
	
		if(A == null && B == null)
			return true;
		
		if(A == null || B == null)
			return false;
		
		Stack<Node> stA = new Stack<>();
		
		Stack<Node> stB = new Stack<>();
		
		while(true) {
			
			while(A != null && B != null) {
				
				if(A.data != B.data)
					return false;
				
				stA.push(A);
				stB.push(B);
				
				A = A.left;
				B = B.right;
			}
			
			if(!(A == null && B == null))
				return false;
			
			if(!stA.isEmpty() && !stB.isEmpty()) {
				
				A = stA.pop();
				B = stB.pop();
				
				A = A.right;
				B = B.left;
			}
			else
				break;
		}
		
		return true;
	}
}
