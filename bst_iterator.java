// Time Complexity : O(n)
// Space Complexity : O(n) where n is no of nodes of tree


class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st=new Stack();
        inorder(root);
    }
    
    public void inorder(TreeNode root){
        while(root!=null){
            st.push(root);
            root=root.left;
        }
    }
    public int next() {
         TreeNode n = st.pop();
         if(n.right!=null){
             inorder(n.right);
         }
        return n.val;
    }
    
    public boolean hasNext() {
        return st.size()>0;
    }
}
