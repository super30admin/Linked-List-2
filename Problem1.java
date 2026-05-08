// https://leetcode.com/problems/binary-search-tree-iterator/
// Time Complexity : 
// O(1) for hasNext()
// O(1) for next() on average case or amortized case
// O(h) for next() for worst case, where h is the height of the tree
// Space Complexity : O(h) for the stack, where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

class BSTIterator {
    private Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        this.st = new Stack<TreeNode>();
        dfs(root);
    }

    private void dfs(TreeNode root) {
        while (root != null) {
            st.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode result = st.pop();
        dfs(result.right);
        return result.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }
}