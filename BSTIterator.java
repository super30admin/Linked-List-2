//TimeComplexity O(1)
//SpaceComplexity O(h) where h is height of tree

class BSTIterator {
    
    Stack<TreeNode> st;
    

    public BSTIterator(TreeNode root) {
        st=new Stack<>();
        dfs(root);
    }
    
    public int next() {
        TreeNode result=st.pop();
        dfs(result.right);
        return result.val;
    }
    
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