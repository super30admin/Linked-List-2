/***
 Approach - Using iterative inorder traversal
 TC - O(n), SC - O(h)
 */


import java.util.Stack;

class BSTIterator {

    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        dfs_helper(root);
    }

    public int next() {
        //return the smallest element
        TreeNode curr = st.pop();

        if(curr.right != null)
            dfs_helper(curr.right);

        return curr.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

    private void dfs_helper(TreeNode root) {
        while(root != null) {
            st.push(root);
            root = root.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */