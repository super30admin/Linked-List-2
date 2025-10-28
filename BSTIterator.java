import java.util.Stack;

/**
 * LeetCode: https://leetcode.com/problems/binary-search-tree-iterator/
 *
 * Approaches:
 *
 * 1. Stack-based Inorder Traversal:
 *    - Use a stack to simulate the inorder traversal of the BST.
 *    - In the constructor, push all the leftmost nodes of the root onto the stack.
 *    - For next(), pop the top node from the stack, then push all the leftmost nodes of its right child.
 *    - hasNext() checks if the stack is not empty.
 *    - This approach ensures O(1) amortized time for next() and hasNext(), and O(h) space, where h is the height of the tree.
 */

public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        helper(root.left);
    }

    private void helper(TreeNode node){
        if(node == null) return;
        stack.push(node);
        helper(node.left);
    }

    public int next() {
        TreeNode node = stack.pop();
        helper(node.right);
        return  node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }


    public class TreeNode {
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
}
