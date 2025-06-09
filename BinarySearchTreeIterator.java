// Time Complexity : O(h)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
    private Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {     //TC: O(h), SC: O(h)
        this.st = new Stack<>();
        dfs(root);
    }
    
    private void dfs(TreeNode root){
        while(root != null){
            st.push(root);
            root = root.left;
        }
    }
    public int next() { //controlled way O(h)-worst case, amortised - O(1), SC: O(h)
        TreeNode curr = st.pop();
        dfs(curr.right);
        return curr.val;
    }
    
    public boolean hasNext() { //TC: O(1), SC: O(1)
        return !st.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */