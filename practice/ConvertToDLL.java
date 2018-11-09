package practice;

public class ConvertToDLL {

	static Node head;
	
	static Node prev = null;
	
	public static void main(String[] args) {

		Node A = new Node(1);
		A.left = new Node(2);
		A.right = new Node(3);
		A.left.left = new Node(4);
		A.left.right = new Node(5);
		A.right.right = new Node(6);
		
		convertToDLL(A);
		
		printList(head);
		
	}
	
	private static void printList(Node head) {
		
		Node temp = head;
		
		while(temp!=null) {
			System.out.print(temp.data + " ");
			temp = temp.right;
		}
		
		System.out.println();
	}
	
	private static void convertToDLL(Node root) {
		if(root == null)
			return;

		convertToDLL(root.left);
		
		if(prev == null)
			head = root;
		else {
			root.left = prev;
			prev.right = root;
		}
		
		prev = root;
		
		convertToDLL(root.right);
	}
	
	
}
