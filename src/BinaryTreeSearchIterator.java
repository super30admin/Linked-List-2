// Time Complexity : O(1)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


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
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        dfs(root);
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode node = st.pop();
        dfs(node.right);
        
        return node.val;
    }
    
    //go left till we hit left
    private void dfs(TreeNode node) {
        while(node != null) {
            st.push(node);
            node = node.left;
        }
    }
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(!st.isEmpty()) return true;
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */