// Time Complexity : O(1) amortized
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
class BSTIterator {
    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        this.st = new Stack<>();
        dfs(root);
    }

    private void dfs(TreeNode root){
        while(root != null){
            st.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode temp = st.pop();
        dfs(temp.right);
        return temp.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }
}