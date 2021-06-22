class BSTIterator {
    Stack<TreeNode> st= new Stack<>();//Stack to maintain all the left most element
    
    public BSTIterator(TreeNode root) {
            dfs(root);
        }
    
    public void dfs(TreeNode root)//dfs to traverse till left and check right only when next() function is called.
    {
           while(root!=null){
                st.push(root);
                root=root.left;
            }       
    }
    
    public int next() {
        if(hasNext())
        {
            TreeNode temp=st.pop();
            if(temp.right!=null)
                dfs(temp.right);
            return temp.val;
        }
        return -1;
    }
    
    public boolean hasNext() {
        if(!st.isEmpty())
            return true;
        return false;
    }
}