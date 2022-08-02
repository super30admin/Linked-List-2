// Time Complexity :O(1)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


class bstIterator {
    Stack<TreeNode> st;

    public bstIterator(TreeNode root) {
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