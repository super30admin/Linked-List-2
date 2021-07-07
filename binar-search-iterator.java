// Time Complexity : O(1)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode cursor=root;
        while(cursor != null)
        {
            stack.push(cursor);
            cursor=cursor.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode result=stack.pop();
        TreeNode cursor=result.right;
        while(cursor != null)
        {
            stack.push(cursor);
            cursor=cursor.left;
        }
        return result.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */