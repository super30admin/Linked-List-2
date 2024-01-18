import java.util.*;

public class BSTIterator {
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
    Stack<TreeNode> stack;
    TreeNode root;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        this.root = root;
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    // TC: O(H)
    public int next() {
        TreeNode curr = stack.pop();
        root = curr.right;
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        return curr.val;
    }

    // TC: O(1)
    public boolean hasNext() {
        return !stack.isEmpty();
    }

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
}
