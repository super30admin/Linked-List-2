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
class BSTIterator {
    List<Integer> l;
    int idx;
    public BSTIterator(TreeNode root) {
        this.l = new ArrayList<>();
        helper(root);
    }

    public void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        l.add(root.val);
        helper(root.right);
    }

    public int next() {
        int r  = l.get(idx);
        idx++;
        return r;
    }

    public boolean hasNext() {
        return idx != l.size();
    }
    
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */