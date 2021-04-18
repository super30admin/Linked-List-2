// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

// Your code here  with comments explaining your approach

public class BSTIterator {

  private TreeNode visit;
  private Stack<TreeNode> stack;

  public BSTIterator(TreeNode root) {
    visit = root;
    stack = new Stack();
  }

  public boolean hasNext() {
    return visit != null || !stack.empty();
  }

  public int next() {
    while (visit != null) {
      stack.push(visit);
      visit = visit.left;
    }
    TreeNode next = stack.pop();
    visit = next.right;
    return next.val;
  }
}