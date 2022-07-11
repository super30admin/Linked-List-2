//Time : O(1)
//Space: O(h)

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
        TreeNode curr = st.pop();
        // int temp = curr.val;
        dfs(curr.right);
        return curr.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }
}

public class BSTiterator {

}
