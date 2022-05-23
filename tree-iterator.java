//Time Complexity: O(1)
//Space Complexity:o(1)
//Did this code successfully run on Leetcode :Yes

class BSTIterator {
    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        dfs(root);
    }

    public int next() {
        TreeNode resultNode = st.pop();
        dfs(resultNode.right);
        return resultNode.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();

    }

    public void dfs(TreeNode root) {
        while (root != null) {
            st.push(root);
            root = root.left;
        }
        return;
    }
}