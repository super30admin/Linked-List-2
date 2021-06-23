// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : from class, not sure about this too much


// Your code here along with comments explaining your approach

class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        dfs(root);
    }
    
    public int next() {
        TreeNode node = st.pop();
        dfs(node.right);
        return node.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
    
    private void dfs(TreeNode root){
        while(root != null){
            st.push(root);
            root = root.left;
        }
    }
}