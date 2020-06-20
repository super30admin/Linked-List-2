// Time Complexity : O(h) worst case and O(1) average time
// Space Complexity : O(h) --> where h is height of tree
// Did this code successfully run on Leetcode (173): Yes 
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        dfs(root);
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode node = st.pop();
        dfs(node.right);
        return node.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !st.isEmpty();
    }
    
    private void dfs(TreeNode root) {
        while (root != null) {
            st.push(root);
            root = root.left;
        }
    }
}

