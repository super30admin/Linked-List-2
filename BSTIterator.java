/**
 * Problem: https://leetcode.com/problems/binary-search-tree-iterator/
 * TC: O(1) - amortized time for all functions
 * SC: O(h) where h = height of the tree
*/
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
        st = new Stack<TreeNode>();    
        populateStack(root);
    }
    
    public int next() {
        TreeNode node = st.pop();
        if (node.right != null)
            populateStack(node.right);
        return node.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
    
    private void populateStack(TreeNode root) {
        while (root != null) {
            st.push(root);
            root = root.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */