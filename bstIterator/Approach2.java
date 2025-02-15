package bstIterator;

// Time Complexity : O(n)
// Space Complexity : O(n) O(h) height of the balanced BST
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
class Approach2 {

    private Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        this.st = new Stack();
        dfs(root);
    }

    private void dfs(TreeNode root) {
        while (root != null) {
            this.st.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode res =  st.pop();
        dfs(res.right);

        return res.val;
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
