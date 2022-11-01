class BSTIterator {
    Stack<TreeNode> s;
    public BSTIterator(TreeNode root) {
         s = new Stack<>();
        i(root);
    }
    public void i(TreeNode n){
        while(n!=null){
            s.push(n);
            n = n.left; 
        }
    }
    public int next() {
        TreeNode t = s.pop();
        i(t.right);
        return t.val;
    }
    
    public boolean hasNext() {
        if(s.isEmpty()){
            return false;
        }
        return true;
    }
}
//tc=O(n)
//sc=O(n)
