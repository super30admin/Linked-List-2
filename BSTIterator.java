// Did this code run successfully on Leetcode : Yes
// Space Complexity : O(h)
class BSTIterator {
    Stack<TreeNode> st = new Stack<>();
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        helper(root);
    }

    private void helper(TreeNode root) { // O(h)
        if(root == null) return;
        st.push(root);
        helper(root.left);
    }

    public int next() { // O(1) on average
        TreeNode curr = st.pop();
        helper(curr.right);
        return curr.val;

    }

    public boolean hasNext() { // O(1)
        return !st.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */