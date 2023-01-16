// Time Complexity : O(1) Amortized
// Space Complexity : O(N)
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

public class BinarySearchTreeIterator {
    private Stack<TreeNode> treeNodeStack;

    public BSTIterator(TreeNode root) {
        treeNodeStack = new Stack<>();
        dfs(root);
    }

    private void dfs(TreeNode root) {
        while (root != null) {
            treeNodeStack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode top = treeNodeStack.pop();
        dfs(top.right);
        return top.val;
    }

    public boolean hasNext() {
        return !treeNodeStack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */