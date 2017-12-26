/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/

// Problem statement: https://practice.geeksforgeeks.org/problems/longest-consecutive-sequence-in-binary-tree/1/?ref=self

/* Summary: Given the root note of a Binary Tree, return the longest consecutive sequence of nodes where each node is exactly 1 
greater than the node before it */

/*Complete the function below
Node is as follows
class TreeNode
{
    int key;
    TreeNode left, right;
    public TreeNode(int key)
    {
        this.key = key;
        left = right = null;
    }
}*/
class GfG
{
    private int maxCount = 1;
    public int longestConsecutive(TreeNode root)
    {
        getCount(root, root.key, 1);
        return maxCount == 1 ? -1 : maxCount;
    }
    
    private void getCount(TreeNode root, int data, int count) {
        if(root != null) {
            if(root.key == data + 1) {
                count++;
                if(count > maxCount) {
                    maxCount = count;
                }
            } else {
                count = 1;
            }
            data = root.key;
            getCount(root.left, data, count);
            getCount(root.right, data, count);
        }
    }
}
