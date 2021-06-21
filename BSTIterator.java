//TC O(N)
//SC O(N)
class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        dfs(root);
    }

    public int next() {
        TreeNode node = st.pop();
        dfs(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

    public void dfs(TreeNode root) {
        while(root!=null) {
            st.push(root);
            root = root.left;
        }
    }
}