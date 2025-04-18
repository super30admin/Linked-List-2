package java;

import java.util.Stack;

public class BinarySearchTreeIterator {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */

    Stack<TreeNode> st;

    public BinarySearchTreeIterator(TreeNode root) {
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
        TreeNode tmp = st.pop();
        dfs(tmp.right);
        return tmp.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

//TC: amortized TC: O(1)
//SC: O(h)
