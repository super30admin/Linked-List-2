package bstIterator;

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Approach1 {

    private List<Integer> result;
    private int idx;

    public BSTIterator(TreeNode root) {
        this.result = new ArrayList();
        inorder(root);
    }

    private void inorder(TreeNode root) {
        // base
        if(root == null ) {
            return;
        }

        // logic
        inorder(root.left);
        result.add(root.val);
        inorder(root.right);
    }

    public int next() {
        int re = result.get(idx);
        idx++;

        return re;
    }

    public boolean hasNext() {
        return idx != result.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */