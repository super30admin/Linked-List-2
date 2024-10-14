class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st= new Stack<>();
        dfs(root);
    }
    private void dfs(TreeNode root){
        if(root==null) return;
        st.push(root);
        dfs(root.left);
    }
    
    public int next() {
        if(hasNext()){
            TreeNode root = st.pop();
            dfs(root.right);
            return root.val;
        }
        return -1;
    }
    
    public boolean hasNext() {
        return (!st.isEmpty());
    }
}
