//Time Complexity: O(1)
//Space Complexity: O(h)
import java.util.Stack;

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
  class BSTIterator {
      private Stack<TreeNode> st;

      public BSTIterator(TreeNode root) {
          this.st = new Stack<>();
          recurse(root);
      }


      private void recurse(TreeNode root) {
          while (root != null) {
              st.push(root);
              root = root.left;
          }
      }

      public int next() {
          TreeNode result = st.pop();
          recurse(result.right);
          return result.val;
      }

      public boolean hasNext() {
          return !st.isEmpty();
      }
  }