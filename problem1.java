//Problem1 - https://leetcode.com/problems/binary-search-tree-iterator/

// Time Complexity : Mentioned below for each function
// Space Complexity : Mentioned below for each function
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nothing as such

public class problem1 {
    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        helper(root);
    }

    private void helper(TreeNode root) {
        while (root != null) {
            st.push(root);
            root = root.left;
        }
    }

    public int next() { // O(h) - Worst case......... Avg = O(1)
        TreeNode node = st.pop();
        helper(node.right);
        return node.val;
    }

    public boolean hasNext() { // O(1)
        return !st.isEmpty();
    }
}
