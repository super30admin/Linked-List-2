// Time Complexity : O(n) over n calls (total)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        TreeNode node = root;
        dfs(node);
    }
    public int next() {
        TreeNode node = st.pop();
        dfs(node.right);
        return node.val;
    }
    public boolean hasNext() {
        return !st.isEmpty();
    }
    private void dfs(TreeNode node) {
        while (node != null) {
            st.push(node);
            node = node.left;
        }
    }
}
