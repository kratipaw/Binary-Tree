package practice;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepthOfBT {

	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2); 
        root.right = new Node(3); 
        root.left.left = new Node(4); 
        root.left.right = new Node(5); 
        root.right.right = new Node(8); 
        root.right.right.left = new Node(6); 
        root.right.right.right = new Node(7);
        
        System.out.println(minDepth(root));
		
	}

	//Using Level Order Traversal
	private static int minDepth(Node node) {
		
		if(node == null)
			return 0;
		
		Queue<Node> qu = new LinkedList<>();
		
		qu.add(node);
		
		int minDepth = 0;
		
		while(!qu.isEmpty()) {
			
			int count = qu.size();
			
			if(count>0)
				minDepth++;
			else
				break;
			
			while(count > 0) {
				
				Node temp = qu.poll();
				
				if(temp.left == null && temp.right == null)
					return minDepth;
				
				if(temp.left != null)
					qu.add(temp.left);
				
				if(temp.right != null)
					qu.add(temp.right);
				
				count--;
			}
		}
		
		return minDepth;
	}
	
}
