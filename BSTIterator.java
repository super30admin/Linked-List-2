
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :
// Need to check how could we implement using basic array 	

// Your code here along with comments explaining your approach
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {

 Queue <TreeNode> queue = new LinkedList <> ();
    public BSTIterator(TreeNode root) 
    {
        addNodes(root);
    }
    
    public void addNodes (TreeNode root)
    {
        if (root == null)
            return;
        
        addNodes(root.left);
        queue.add(root);
        addNodes(root.right);
    }
    
    /** @return the next smallest number */
    public int next() 
    {
        return queue.poll().val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() 
    {
        return (queue.size() != 0);    
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */