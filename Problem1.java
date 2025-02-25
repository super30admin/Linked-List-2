class BSTIterator {
    Stack<TreeNode>  st ;

    public BSTIterator(TreeNode root) {
        this.st = new Stack<>();
        dfs(root);

    }
    private void dfs(TreeNode root){

        while(root!=null){
            st.push(root);
            root=root.left;
        }
    }

    public int next() {

        TreeNode res = st.pop();
        dfs(res.right);
        return res.val;

    }

    public boolean hasNext() {
        return !st.isEmpty();
    }
}