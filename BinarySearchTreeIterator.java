// Time Complexity : O(1) Average
// Space Complexity : O(H) 
// Did this code successfully run on Leetcode : Yes

class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        dfs(root);
    }
    
    private void dfs(TreeNode root){
        while(root!=null){
            st.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode cur = st.pop();
        dfs(cur.right);
        return cur.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}
