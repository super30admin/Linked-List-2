// Time Complexity : O(h)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : YES


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
class BSTIterator_LC173 {

    private Stack<TreeNode> stack = new Stack<TreeNode>();

    public BSTIterator(TreeNode root) {
        pushAll(root);
    }
    
    public int next() {
        TreeNode tempNode = stack.pop();
        pushAll(tempNode.right);
        return tempNode.val;
    }
    
    public boolean hasNext() {
        return (!stack.isEmpty());
    }

    private void pushAll(TreeNode node) {
        // compact for-loop commonly used in binary tree traversal, especially in-order traversal.
            // for (; node != null; stack.push(node), node = node.left);

        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */