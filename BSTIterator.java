// Time Complexity : O(1) average
// Space Complexity : O(h) h=height of stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// Iteration with controlled recursion

class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        helper(root);
    }
    
    private void helper(TreeNode root) {
        while(root!=null) {
            st.push(root);
            root=root.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode root = st.pop();
        int ret = root.val;
        helper(root.right);
        return ret;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(!st.isEmpty()) return true;
        return false;
    }
}