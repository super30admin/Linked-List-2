// Time Complexity : BSTIterator : O(n), hasNext : O(1), next : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

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
 * } */

class BSTIterator {

    ArrayList<Integer> data = new ArrayList<>();
    int idx = -1;

    public BSTIterator(TreeNode root) {
        Inorder(root);

    }

    public void Inorder(TreeNode root) {
        if (root != null) {

            Inorder(root.left);
            data.add(root.val);
            Inorder(root.right);
        }
    }

    public int next() {
        idx++;
        return data.get(idx);

    }

    public boolean hasNext() {
        if (idx == data.size() - 1) {
            return false;
        }
        return true;

    }
}
