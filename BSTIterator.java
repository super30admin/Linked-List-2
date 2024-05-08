import java.util.Stack;

// Time Complexity : O(1) for next() and O(1) for hasNext()
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

/**
 * A naive approach would be to store the inorder traversal of the tree
 * in a list and then use the list to get the next element.
 *
 * But this approach would take O(n) space and O(n) time in the constructor.
 *
 * An optimized approach would be to use a stack to store the leftmost
 * elements of the tree. Whenever next() is called, we pop the top element
 * and go to right and again push the leftmost elements to the stack.
 * This way we are processing only a set of elements at a time, not all at once.
 */

public class BSTIterator {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        this.st = new Stack<>();
        helper(root);
    }

    private void helper(TreeNode root) {
        while (root != null) {
            st.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode res = st.pop();
        helper(res.right);
        return res.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }
}
