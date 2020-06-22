/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// Time complexity is O(1) and space complexity is O(h) where h is the height of the tree
class BSTIterator {
  Stack <TreeNode> st;
  public BSTIterator(TreeNode root) {
    st = new Stack<>();
    TreeNode node = root;
    dfs(node);
  }

  /** @return the next smallest number */
  public int next() {
    TreeNode node = st.pop();
    dfs(node.right);
    return node.val;
  }

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
    return !st.isEmpty();
  }

  private void dfs(TreeNode node){
    while(node != null){
      st.push(node);
      node = node.left;
    }

  }
}
