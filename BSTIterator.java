// Time Complexity : next() => O(1) amortized; worse case O(h); hasNext() => O(1)
// Space Complexity : O(1); stack is used in the constructor
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// implementing iterative inorder traversal but stopping at the left most element;
// only when that element is processed, we push the right child and all of it's left children
// This ensures the top of the stack to have the right inorder element

import java.util.Stack;

// Definition for a binary tree node.
class TreeNode {
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

class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        this.stack = new Stack<TreeNode>();
        pushLeftChildren(root);
    }

    public int next() {
        TreeNode node = stack.pop();
        // push right child and all of it's left children to maintain inorder
        pushLeftChildren(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return stack.size() > 0;
    }

    private void pushLeftChildren(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
