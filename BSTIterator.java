import java.util.ArrayList;

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
  // Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class BSTIterator {
    ArrayList<Integer> inorder;
    int index;
    public BSTIterator(TreeNode root) {
        index = -1;
        inorder = new ArrayList<>();
        find_inorder(root);

    }
    public void find_inorder(TreeNode root) {
        if (root == null)
            return;
        find_inorder(root.left);
        inorder.add(root.val);
        find_inorder(root.right);
    }

    /** @return the next smallest number */
    public int next() {
        return inorder.get(++index);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (index + 1) < inorder.size();
    }
}
