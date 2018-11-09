package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class VerticalTraversal {

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
		root.left.right.right.left = new Node(10);
		root.left.right.right.right = new Node(11);
		
		verticalTraversal(root);
	}

	private static void verticalTraversal(Node root) {
		
		if(root == null)
			return;
		
	    HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
	 
	    Queue<Node> queue = new LinkedList<Node>();
	    Queue<Integer> level = new LinkedList<Integer>();
	 
	    queue.add(root);
	    level.add(0);
	 
	    int minHD=0;
	    int maxHD=0;
	 
	    while(!queue.isEmpty()){
	        Node temp = queue.poll();
	        int l = level.poll();

	        minHD=Math.min(minHD, l);
	        maxHD=Math.max(maxHD, l);
	 
	        if(map.containsKey(l)){
	            map.get(l).add(temp.data);
	        }
	        else{
	            ArrayList<Integer> list = new ArrayList<Integer>();
	            list.add(temp.data);
	            map.put(l, list);
	        }
	 
	        if(temp.left!=null){
	            queue.add(temp.left);
	            level.add(l-1);
	        }
	 
	        if(temp.right!=null){
	            queue.add(temp.right);
	            level.add(l+1);
	        }
	    }
	 
	 
	    for(int i=minHD; i<=maxHD; i++){
	        if(map.containsKey(i)){
	            System.out.println(map.get(i));
	        }
	    }
		
	}
}
