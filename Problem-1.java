import java.util.Stack;

// Time Complexity : next(): O(1) amortized time complexity hasNext(): O(1)
// Space Complexity : O(h) where h is height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// We use stack to process controlled dfs (only untill we reach the next leaf node)
// In next() we just pop one element from stack and proceed to its right subtree
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

    private void dfs(TreeNode root) {
        while (root != null) {
            st.push(root);
            root = root.left;
        }
    }
}