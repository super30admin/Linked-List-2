import java.util.Stack;

// Time Complexity : O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this: getting started, watched class lectures

// Your code here along with comments explaining your approach

public class BinarySearchTreeIterator {

    /**
      Definition for a binary tree node.
     **/
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
          //declare stacj and intialize in constructor
          Stack<TreeNode> st;
        public BSTIterator(TreeNode root) {
            st = new Stack<>();
            dfs(root);
        }

        //remove top of stack and return the value, also check the right nodes
        public int next() {
            TreeNode result = st.pop();
            dfs(result.right);
            return result.val;
        }

        public boolean hasNext() {
            //return boolean value of state of stack
            return !st.isEmpty();

        }

        private void dfs(TreeNode root){
            //push left node on to stack
            while(root != null){
                st.push(root);
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
}
