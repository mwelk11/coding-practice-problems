/*

Problem found here: https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1/

Summary: Given a root node of a BST, print the bottom most nodes at each horizontal distance from the root node 
(i.e. horizontal distance of root is 0, root.left is -1, root.right is 1, and so on). If there are multiple nodes 
at the same horizontal level, print the right most node.

Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/* Tree node class
class Node {
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}*/

class GfG
{
    private TreeMap<Integer, ArrayList<Integer>> tm;
    // Should print bottom view of tree with given root
    public void bottomView(Node root)
    {
        tm = new TreeMap<Integer, ArrayList<Integer>>();
        populateTreeMap(root, 0);
        Set<Map.Entry<Integer, ArrayList<Integer>>> entries = tm.entrySet();
        for(Map.Entry<Integer, ArrayList<Integer>> entry : entries) {
            ArrayList<Integer> nodeList = entry.getValue();
            System.out.print(nodeList.get(nodeList.size()-1) + " ");
        }
        
    }
    
    private void populateTreeMap(Node root, int horzDist) {
        if(root != null) {
            if(tm.containsKey(horzDist)) {
                tm.get(horzDist).add(root.data);
            } else {
                ArrayList<Integer> nodeList = new ArrayList<Integer>();
                nodeList.add(root.data);
                tm.put(horzDist, nodeList);
            }
            populateTreeMap(root.left, horzDist-1);
            populateTreeMap(root.right, horzDist+1);
        }
    }
}
	
