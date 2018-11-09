package practice;

import java.util.Stack;

public class Postorder {

	public static void main(String[] args) {

		Node node = new Node(1);
		node.left = new Node(2);
		node.right = new Node(3);
		node.left.left = new Node(4);
		node.left.right = new Node(5);
		node.right.left = new Node(6);
		node.right.right = new Node(7);
		
		System.out.println("Postorder Tree traversal is : ");
		
		postorder_recursive(node);
		System.out.println();
		
		postorder_iterative(node);
		
		postorder_iterative_2(node);
	}
	
	//Recursion, TC = O(n), SC = O(1) excluding stack call
	private static void postorder_recursive(Node node) {
		
		if(node == null)
			return;
		
		postorder_recursive(node.left);
		
		postorder_recursive(node.right);
		
		System.out.print(node.data + " ");
		
	}
	
	//Using 2 stacks, TC = O(n), SC = O(n)
	private static void postorder_iterative(Node node) {
		
		if(node == null)
			return;
		
		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();
	
		stack1.add(node);
		
		while(!stack1.isEmpty()) {
			
			Node temp = stack1.pop();
			stack2.add(temp);
			
			if(temp.left!=null)
				stack1.add(temp.left);
			
			if(temp.right!=null)
				stack1.add(temp.right);
		}
		
		while(!stack2.isEmpty()) {
			System.out.print(stack2.pop().data + " ");
		}
		System.out.println();
	}
	
	private static void postorder_iterative_2(Node root) {
		
		if(root == null)
            return;

		Stack<Node> st = new Stack<>();

		st.add(root);

		Node prev = null;

		while(!st.isEmpty()) {

            Node curr = st.peek();

            if(prev == null || prev.left == curr || prev.right == curr) {
              if(curr.left!=null)
                     st.add(curr.left);
              else if(curr.right != null)
                     st.add(curr.right);
              else {
                     st.pop();
                     System.out.print(curr.data + " ");
              }
            }
            else if (curr.left == prev) {
              if(curr.right != null)
                 st.add(curr.right);
              else {
                 st.pop();
                 System.out.print(curr.data + " ");
              }
            }
            else if(curr.right == prev) {
              st.pop();
              System.out.print(curr.data + " ");
            }
            
            prev = curr;
		}
	}

}
