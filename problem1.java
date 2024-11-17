//Problem1 (https://leetcode.com/problems/binary-search-tree-iterator/)
//Time Complexity:
//        Constructor: O(h)
//        next(): Amortized O(1)
//        hasNext(): O(1)
//        Space Complexity: O(h)
// Did this code successfully run on Leetcode :
// Yes

// Any problem you faced while coding this :
// No major issues, but I had to ensure that the in-order traversal
// logic was correctly implemented using the stack to maintain efficiency.

// Your code here along with comments explaining your approach
/*
    Approach:
    1. Use a stack to perform in-order traversal of the BST.
    2. In the constructor, push all left nodes from the root to the stack.
    3. `next()` returns the next smallest element by popping from the stack.
       - If the popped node has a right child, push all left nodes from the right subtree.
    4. `hasNext()` checks if the stack is empty to determine if there are more elements.
    5. Time Complexity:
       - Constructor: O(h), where h is the height of the tree.
       - `next()`: Amortized O(1) per call.
       - `hasNext()`: O(1)
    6. Space Complexity: O(h), where h is the height of the tree.
*/
import java.util.Stack;

public class problem1 {

     // Definition for a binary tree node.
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

    class BSTIterator {

        private Stack<TreeNode> stack = new Stack<TreeNode>();

        public BSTIterator(TreeNode root) {
            pushAllLeft(root);
        }
        // Returns the next smallest number in the BST
        public int next() {
            TreeNode node = stack.pop();
            if (node.right != null) {
                pushAllLeft(node.right);
            }
            return node.val;
        }

        // Returns true if there is a next smallest number
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        // Helper function to push all left nodes onto the stack
        private void pushAllLeft(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

    }


}
