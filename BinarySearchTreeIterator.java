// Time Complexity : O(1)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
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
class BSTIterator {

  Stack<TreeNode> stack;

  public BSTIterator(TreeNode root) {
    stack = new Stack<>();
    dfs(root);
  }

  // returns popped element and adds the node to the right of it, if it exists.
  public int next() {
    TreeNode answer = stack.pop();
    dfs(answer.right);
    return answer.val;
  }

  // Checks if stack is empty.
  public boolean hasNext() {
    return !stack.isEmpty();
  }

  // Adds the node to the left of the root.
  void dfs(TreeNode root) {
    while(root!=null) {
      stack.push(root);
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