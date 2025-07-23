class BSTIterator {
    Stack<TreeNode>s;
    public BSTIterator(TreeNode root) {
        s=new Stack<>();
        dfs(root);

    }
    
    public int next() {
        TreeNode popp=s.pop();
        dfs(popp.right);
        return popp.val;  
    }
    
    public boolean hasNext() {
        return !s.isEmpty();
    }
    private void dfs(TreeNode root){
        while(root!=null){
            s.push(root);
            root=root.left;
        }
    }
}
