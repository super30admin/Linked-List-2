// Time Complexity : O(1)
// Space Complexity : O(n)

class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new  Stack<>();
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
    
    private void dfs(TreeNode root){
        while(root != null){
            st.push(root);
            root  = root.left;
        }
    }
}