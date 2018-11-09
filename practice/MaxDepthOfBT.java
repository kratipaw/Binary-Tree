package practice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Max Depth is also Height of BT
 */

public class MaxDepthOfBT {

	public static void main(String[] args) {
		
		Node root = new Node(1);
		root.left = new Node(2); 
        root.right = new Node(3); 
        root.left.left = new Node(4); 
        root.left.right = new Node(5); 
        root.right.right = new Node(8); 
        root.right.right.left = new Node(6); 
        root.right.right.right = new Node(7);
        
        System.out.println(maxDepth_recur(root));

        System.out.println(maxDepth_iterative(root));
        
	}
	
	//TC = O(n)
	private static int maxDepth_recur(Node node) {
		
		if(node == null)
			return 0;
		
		int lHeight = maxDepth_recur(node.left);
		
		int rHeight = maxDepth_recur(node.right);
		
		if(lHeight > rHeight)
			return 1 + lHeight;
		else
			return 1 + rHeight;
		
	}

	//Using Level Order Traversal : TC = O(n), SC = O(n)
	private static int maxDepth_iterative(Node node) {
		
		if(node == null)
			return 0;
		
		Queue<Node> qu = new LinkedList<>();
		
		qu.add(node);
		
		int height = 0;
		
		while(!qu.isEmpty()) {
			
			int count = qu.size();
			
			if(count > 0)
				height++;
			else
				break;
			
			while(count > 0) {
				
				Node temp = qu.poll();
				
				if(temp.left != null)
					qu.add(temp.left);
				
				if(temp.right != null)
					qu.add(temp.right);
				
				count--;
			}
			
		}
		
		return height;
		
	}
}
