// Time Complexity : Amortized O(1) or O(n worstcase)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * This is a controlled recursion problem.
 * We keep a stack and initialize it with only the left nodes of root.
 * Once we get a next call, we pop the top of the stack and call dfs on right of the popped node.
 * For hasNext() call, we just return true true if the size of the stack is greater than 0.
 */

class BSTIterator {
    
    private Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        dfs(root);
    }
    
    public int next() {
        TreeNode top = st.pop();
        dfs(top.right);
        return top.val;
    }
    
    public boolean hasNext() {
        return st.size() > 0;
    }
    
    private void dfs(TreeNode root) {
        while(root != null) {
            st.push(root);
            root = root.left;
        }
    }
}
