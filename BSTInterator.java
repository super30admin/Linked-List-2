class BSTIterator {
    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        this.st=new Stack<>();
        init(root);
        
    }
    
    
    private void init(TreeNode root){
        while(root!=null){
            st.push(root);
            root=root.left;
        }
    }
    public int next() {
        if(hasNext()){
            TreeNode temp=st.pop();
            init(temp.right);
            return temp.val;
        }
        return -1;
        
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}