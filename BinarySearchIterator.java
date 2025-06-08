
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
// Time complexity - O(1)
// Space Complexity - O(1)
// Did you face any issues - No
// Solved on leetcode - yes
class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushLeftBranch(root);  // Start with the smallest element
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        if (node.right != null) {
            pushLeftBranch(node.right);  // Lazy loading of right subtree
        }
        return node.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    // Helper to push all left children of a node onto the stack
    private void pushLeftBranch(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
