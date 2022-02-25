// Time Complexity : O(n)
// Space Complexity : O(h) where h is the height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: We use a stack. Every time the root is not null, we push the node
// into the stack and make root as root.left. If the root is null, we pop
// from the stack and make root as root.right.

// LC 173. Binary Search Tree Iterator

import java.util.*;

public class BSTIterator {
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

  Stack<TreeNode> stack;

  public BSTIterator(TreeNode root) {
    stack = new Stack<>();

    TreeNode curr = root;

    while (curr != null) {
      stack.push(curr);
      curr = curr.left;
    }
  }

  public int next() {
    TreeNode node = stack.pop();
    fillStack(node.right);

    return node.val;
  }

  public boolean hasNext() {
    return !stack.isEmpty();
  }

  private void fillStack(TreeNode root) {
    while (root != null) {
      stack.push(root);
      root = root.left;
    }
  }
}
