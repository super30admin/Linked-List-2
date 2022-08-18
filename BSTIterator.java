// Time Complexity : Average O(1)
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/**
 * The idea is to process all the left nodes till we hit leaf node and put the nodes in stack
 * This is to simulate the recursive stack
 * 
 * When next is called, we pop the top element from stack and give that.
 * We will explore the right subtree at the current node and populate our stack.
 */

class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        dfs(root);
    }
    
    private void dfs(TreeNode root) {
        while (root != null) {
            st.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode next = st.pop();
        dfs(next.right);
        
        return next.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}