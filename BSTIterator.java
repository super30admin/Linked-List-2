// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes 
class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st=new Stack<>(); 
        dfs(root);
  
    }
    private void dfs(TreeNode root)
    {
        while(root!=null)
        {
            st.push(root);
            root=root.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode root=st.pop();
        dfs(root.right);
        return root.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !st.isEmpty();
    }
}