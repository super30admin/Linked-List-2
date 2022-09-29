// Time Complexity : O(height) - worst, O(1) - average
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

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
        helper(root);
    }

    private void helper(TreeNode root){
        while(root != null){
            st.push(root);
            root = root.left;
        }
    }

    public int next() { //O(height)
        TreeNode node = st.pop();
        helper(node.right);
        return node.val;
    }

    public boolean hasNext() { //O(1)
        return !st.isEmpty();
    }
}