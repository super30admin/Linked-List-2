// Time  - O(N)
// Space - Average  - O(H), Worst H = N
class BSTIterator {
    Stack<TreeNode> s;
    
    public BSTIterator(TreeNode root) {
        s = new Stack<TreeNode>();
        
        if(root != null) {
            dfs(root);
        }
    }
    
    public int next() {
        TreeNode popped = s.pop();
        if(popped.right != null) {
            dfs(popped.right);
        }
        
        return popped.val;
    }
    
    public boolean hasNext() {
        return !s.isEmpty();
    }
    
    private void dfs(TreeNode root) {
        while(root!=null) {
            s.push(root);
            root = root.left;
        }
    }
}
