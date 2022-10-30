// Time Complexity : O(1) for next, O(n) for sleek left tree
// Space Complexity : O(n) for left tree or max number in left subtree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

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
    Stack<TreeNode> s;
    public BSTIterator(TreeNode root) {
        s = new Stack<>();
        addLefts(root);
    }

    public int next() {
        TreeNode popped = s.pop();
        addLefts(popped.right);
        return popped.val;
    }

    public boolean hasNext() {
        return !s.isEmpty();
    }

    private void addLefts(TreeNode root){
        while(root != null) {
            s.push(root);
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