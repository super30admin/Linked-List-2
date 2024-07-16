// Time Complexity: O(1) amortized
// Space Complexity: O(1)

import java.util.Stack;

class BSTIterator {
    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        this.st = new Stack<>();
        dfs(root);
    }

    private void dfs(TreeNode root) {
        while (root != null) {
            st.push(root);
            root = root.left;
        }

    }

    public int next() {
        TreeNode popped = st.pop();
        dfs(popped.right);
        return popped.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }
}
