// Time Complexity : O(1) for hasNext() and O(n) for next and dfs
// Space Complexity : O(n)
// Method used : DFS

class BSTIterator {

    Stack<TreeNode> s;
    
    public BSTIterator(TreeNode root) {
        s = new Stack();
        dfs(root);
    }
    
    public int next() {
        
        TreeNode p = s.pop();
        dfs(p.right);
        return p.val;
    }
    
    public boolean hasNext() {
        
        return (!s.isEmpty()) ? true : false;
    }
    
    private void dfs(TreeNode root)
    {
        while(root != null)
        {
            s.push(root);
            root = root.left;
        }
    }
}