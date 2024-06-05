//time O(1) amortized
//space O(h) recursive stack space

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
        this.st = new Stack<TreeNode>();
        dfs(root);
    }
    
    private void dfs(TreeNode root) {
        while(root != null) {
            st.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode node = st.pop();
        dfs(node.right);
        return node.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}
