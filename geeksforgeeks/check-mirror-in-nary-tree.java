import java.util.*;
import java.lang.*;
import java.io.*;

// Given two n-ary trees, determine of they are mirrors of each other

// Problem Text: https://practice.geeksforgeeks.org/problems/check-mirror-in-n-ary-tree/0

class GFG {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i = 0; i < t; i++) {
		    int nodes = in.nextInt();
		    int edges = in.nextInt();
		    int size = edges*2;
		    int[] nodes1 = new int[size];
		    int[] nodes2 = new int[size];
		    for(int j = 0; j < size; j++) {
		        nodes1[j] = in.nextInt();
		    }
		    for(int j = 0; j < size; j++) {
		        nodes2[j] = in.nextInt();
		    }
		    System.out.println(isMirror(nodes1, nodes2));
		}
	}
	
	private static int isMirror(int[] nodes1, int[] nodes2) {
	    HashMap<Integer, Stack<Integer>> tree1 = new HashMap<>();
	    HashMap<Integer, LinkedList<Integer>> tree2 = new HashMap<>();
	    
	    // Map each node to a stack of all child nodes
	    for(int i = 0; i < nodes1.length-1; i+=2) {
	        Stack<Integer> stack = new Stack<>();
	        if(tree1.containsKey(nodes1[i])) {
	            stack = tree1.get(nodes1[i]);
	        }
	        stack.push(nodes1[i+1]);
	        tree1.put(nodes1[i], stack);
	    }
	    
	    // Map each node to a queue of all child nodes
	    for(int i = 0; i < nodes2.length-1; i+=2) {
	        LinkedList<Integer> queue = new LinkedList<>();
	        if(tree2.containsKey(nodes2[i])) {
	            queue = tree2.get(nodes2[i]);
	        }
	        queue.add(nodes2[i+1]);
	        tree2.put(nodes2[i], queue);
	    }
	    
	    // Compare the stack and queue for each node; If they are the same, then the trees are mirrors
	    for(Map.Entry<Integer, Stack<Integer>> entry : tree1.entrySet()) {
	        int key = entry.getKey();
	        Stack<Integer> stack =  entry.getValue();
	        LinkedList<Integer> queue =  tree2.get(key);
	        
	        if(stack.pop() != queue.poll()) {
	            return 0;
	        }
	    }
	    
	    return 1;
	}
}
