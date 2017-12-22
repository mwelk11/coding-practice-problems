/*
Problem Statement: https://practice.geeksforgeeks.org/problems/find-the-closest-element-in-bst/1

Summary: Given the root node and an integer value, return the node that has the minimum absolute difference with the value. 
In the case where multiple nodes have the same difference, return the node with the largest data.

Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node left,right;
	Node(int d){
		data=d;
		left=null;
		right=null;
	}
}*/
class GfG
{
    public static int maxDiff(Node root, int k)
    {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int min = maxDiffRecur(root, k, Integer.MAX_VALUE, hm);
        return hm.get(min);
    }
   
    private static int maxDiffRecur(Node root, int k, int min, HashMap<Integer,Integer> hm) {
        if(root != null) {
            int diff = Math.abs(root.data-k);
            if(diff < min) {
                min = diff;
            }
            if(!hm.containsKey(diff) || hm.get(diff) < root.data) {
                hm.put(diff, root.data);
            }
            int left = maxDiffRecur(root.left, k, min, hm);
            int right = maxDiffRecur(root.right, k, min, hm);
            min = Math.min(left, right);
        }
        return min;
    }
}
