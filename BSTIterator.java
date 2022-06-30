//T(N) = O(1)
//S(N) = O(H)
class BSTIterator {
    Stack<TreeNode> st;
    
    private void helper(TreeNode root){
        while(root!=null)
        {
            st.push(root);
            root=root.left;
        }
        
    }

    public BSTIterator(TreeNode root) {
        st=new Stack();
        helper(root);
        
    }
    
    public int next() {
        TreeNode cu=st.pop();
        int temp=cu.val;
        helper(cu.right);
        return temp;
        
    }
    
    public boolean hasNext() {
        
        return !st.isEmpty();
        
    }
}