class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        dfs(root);  
    }

    private void dfs(TreeNode root) {
        while(root!=null) {
            st.add(root);
            root = root.left;
        }
    } 

    // TimeComplexity: O(h) but amortized O(1) 
    public int next() {
        TreeNode curr = st.pop();
        dfs(curr.right);
        return curr.val;
        
    }
    
    // TimeComplexity: O(1) 
    public boolean hasNext() {  
        return !st.isEmpty(); 
    }
}
