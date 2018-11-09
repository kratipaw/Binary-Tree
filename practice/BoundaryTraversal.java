package practice;

public class BoundaryTraversal {

	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.right = new Node(6);
		root.left.right.left = new Node(7);
		root.left.right.right = new Node(8);
		root.right.right.left = new Node(9);
		
		printBoundary(root);
	}

	private static void printBoundary(Node root) {
		
		if(root == null)
			return;
		
		System.out.print(root.data + " ");
		
		printLeftBoundary(root.left);
		
		printLeafNodes(root.left);
		printLeafNodes(root.right);
		
		printRightBoundary(root.right);
	}
	
	private static void printLeftBoundary(Node node) {
	
		if(node == null)
			return;
		
		if(node.left!=null) {
			System.out.print(node.data + " ");
			printLeftBoundary(node.left);
		}
		
		else if(node.right!=null) {
			System.out.print(node.data + " ");
			printLeftBoundary(node.right);
		}
	}
	
	private static void printLeafNodes(Node node) {
		
		if(node == null)
			return;
		
		printLeafNodes(node.left);
		
		if(node.left == null && node.right == null)
			System.out.print(node.data + " ");
		
		printLeafNodes(node.right);
	}
	
	private static void printRightBoundary(Node node) {

		if(node == null)
			return;
		
		if(node.right!=null) {
			printRightBoundary(node.right);
			System.out.print(node.data + " ");
		}
		else if(node.left!=null) {
			printRightBoundary(node.left);
			System.out.print(node.data + " ");
		}
	}
}
