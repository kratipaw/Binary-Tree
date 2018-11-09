package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class DiagonalTraversal {

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
		
		HashMap<Integer, ArrayList<Integer>> result = new HashMap<>();
		
		diagonalTraversal(root, 0, result);
		
		for (Entry<Integer, ArrayList<Integer>> entry : result.entrySet()) 
        { 
            System.out.println(entry.getValue()); 
        }
		
	}

	private static void diagonalTraversal(Node root, int d, HashMap<Integer, ArrayList<Integer>> map) {
		
		if(root == null)
			return;
		
		ArrayList<Integer> temp = map.get(d);
		
		if(temp == null || temp.size()==0) {
			temp = new ArrayList<>();
			temp.add(root.data);
		}
		else
			temp.add(root.data);
		
		map.put(d, temp);
		
		diagonalTraversal(root.left, d + 1, map);
		
		diagonalTraversal(root.right, d, map);
	}
}
