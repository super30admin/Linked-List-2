//Time complexity: O(1) Worst case-O(h)
//Space Complexity:O(h)

class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st=new Stack();
        dfs(root);
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode res=st.pop();
        dfs(res.right);
        return res.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !st.isEmpty();
    }
    
    private void dfs(TreeNode root){
        while(root!=null){
            st.push(root);
            root=root.left;
        }
    }
}
