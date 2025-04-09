// next() and hasNext() to run in average O(1) time and use O(h) memory, where h is the height of the tree.

/**
 * Provides an iterator for traversing a binary search tree in in-order.
 * The iterator uses a stack to keep track of nodes, ensuring efficient traversal.
 * The next() method pops the stack to return the next smallest element and processes the right subtree.
 */

import java.util.Stack;

public class BSTIterator {

 // Definition for a binary tree node.
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    Stack<TreeNode> stk;

    public BSTIterator(TreeNode root) {
        stk = new Stack<>();
        pushLeft(root);
    }

    public void pushLeft(TreeNode root) {
        while(root != null) {
            stk.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode curr = stk.pop();
        if(curr.right != null) {
            pushLeft(curr.right);
        }
        return curr.val;
    }

    public boolean hasNext() {
        return !stk.isEmpty();
    }
}
