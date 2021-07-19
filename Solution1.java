// Time complexity: O(1) for both next() and hasNext()
// Space complexity: O(d), where d is the maximum depth of the tree.

import java.util.*;

class BSTIterator {
    public class TreeNode {
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

    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        // populate stack
        populateStack(root); 
    }
    
    public void populateStack(TreeNode root) {
        while(root!=null) {
            stack.push(root); 
            root = root.left; 
        }
    }
    
    public int next() {
        // the top of the stack is the next smallest element
        TreeNode node = stack.pop();
        // if right tree of the node is not null, populate stack
        if(node.right != null) {
            populateStack(node.right); 
        }
        return node.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty(); 
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */