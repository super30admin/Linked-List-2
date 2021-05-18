/*
Desc : using dfs we traverse to left most leaf node from the current node to push the value into stack, everytime a pop is made to 
fulfill the next() functionality while the stack empty method is used for hasnext functionality.
Time Complexity : O(n)
Space Complexity : O(1)
*/
class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        dfs(root);
    }
    
    public int next() {
        TreeNode result = st.pop();
        dfs(result.right);
        return result.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
    private void dfs(TreeNode root){
        while(root!=null){
            st.push(root);
            root = root.left;
        }
    }
}
