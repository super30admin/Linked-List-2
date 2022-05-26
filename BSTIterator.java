/**
 * DFS on left in constructor. When get element comes do dfs on right.
 * TC:O(1) for next and has next
 * SC:O(h) height
 */
class BSTIterator {
    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        st = new Stack();
        dfs(root);
    }

    public int next() {
        TreeNode result = st.pop();
        dfs(result.right);
        return result.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

    private void dfs(TreeNode root) {
        while (root != null) {
            st.push(root);
            root = root.left;
        }
    }
}