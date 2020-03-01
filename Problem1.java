// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class BSTIterator {

    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        st = new Stack<>();

        TreeNode cr = root;
        while (cr != null) {
            st.push(cr);
            cr = cr.left;
        }

    }

    /** @return the next smallest number */
    public int next() {
        TreeNode result = st.pop();

        TreeNode cr = result.right;
        while (cr != null) {
            st.push(cr);
            cr = cr.left;
        }

        return result.val;

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !st.isEmpty();
    }
}
