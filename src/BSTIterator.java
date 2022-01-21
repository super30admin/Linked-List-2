import javax.swing.tree.TreeNode;
import java.util.Stack;
// Time Complexity : next worst - O(h) avg - O(1)
//                    hasNext O(1)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

/*
    Doing inorder but only when required
 */
public class BSTIterator {

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

        TreeNode head ;
        Stack<TreeNode> mas;
        public BSTIterator(TreeNode root) {
            mas = new Stack<>();
            //push till first
            helper(root);
        }

        public int next() {
            //check the top element pop it and then go right
            TreeNode n = mas.pop();
            helper(n.right);
            return n.val;
        }

        public boolean hasNext() {
            return  !mas.isEmpty();
        }
        private void helper(TreeNode root) {
            while(root!=null) {
                mas.push(root);
                root = root.left;
            }
        }
    }

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

