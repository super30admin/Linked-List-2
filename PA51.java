//173. Binary Search Tree Iterator
// Time complexity : O(n) //no of nodes in the tree
//Space Complexity: O(n) //At max only nodes equal to height of the tree will be traversed at a time
class BSTIterator {
Stack<TreeNode> st ;
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        dfs(root);
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode n= st.pop();
        dfs(n.right);
        return n.val;
        
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (!st.isEmpty());
    }
    
    public void dfs(TreeNode root){
        while(root!=null){
            st.push(root);
            root=root.left;
        }  
        
    }
    
}
