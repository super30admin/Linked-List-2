//Time Complexity: O(1) --------- User only calls the next() and hasNext() functions and they return in constant time. Need not worry about the constructor calls
//Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes

public class BinarySearchTreeIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        dfs(root);
    }

    public int next() {
        TreeNode result = st.pop();;
        dfs(result.right);
        return result.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

    private void dfs(TreeNode root) {
        while(root != null) {
            st.push(root);
            root = root.left;
        }
    }
}
