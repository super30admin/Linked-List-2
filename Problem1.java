//Accepted on LT
//The idea is to use a stack and perform some functions

class BSTIterator {
    Stack<TreeNode> s ;
    public BSTIterator(TreeNode root) {
        this.s = new Stack<>();
        dfs(root);
        
    }
    public void dfs(TreeNode root){
        
        while(root!=null){
            s.push(root);
            root=root.left;
        }

    }
    
    public int next() {
        TreeNode t = s.pop();
        dfs(t.right);
        return t.val;
        
    }
    
    public boolean hasNext() {
        return !s.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */