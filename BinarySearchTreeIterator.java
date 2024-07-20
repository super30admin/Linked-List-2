/*
    TC:
    next() : O(1) amortized; O(h) worst
    hasNext(): O(1)

    SC: O(h) for stack

*/

class BSTIterator {
    Stack<TreeNode> st;
    private void dfs(TreeNode root) { // O(n)
        while(root != null) {
            st.push(root);
            root = root.left;
        }
    }
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        dfs(root);
    }
    
    public int next() { // O(1) amortized // O(h) worst
        TreeNode top = st.pop();
        dfs(top.right);
        return top.val;
    }
    
    public boolean hasNext() { // O(1)
        return !st.isEmpty();
    }
}