// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class BSTIterator {
    Stack<TreeNode> st = new Stack<>();
    public BSTIterator(TreeNode root) {
        // call recursive dfs function with root
        dfs(root);
    }

    public int next() {
        // to return the next element, pop the stack and
        // perform dfs on on right child of the popped node
        TreeNode result = st.pop();
        dfs(result.right);
        return result.val;
    }

    public boolean hasNext() {
        // check for empty stack if any elements are left
        return !st.isEmpty();
    }
    private void dfs(TreeNode root){
        // keep pushing left nodes in stack until leaf node is found
        while(root != null){
            st.push(root);
            root = root.left;
        }
    }
}