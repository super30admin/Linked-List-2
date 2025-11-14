/**** Method 1 ****/
//Time Complexity: O(n)
//Space Complexity: O(n)

//Successfully submitted in LeetCode

//While initializing the iterator we do a inorder traversal and add all the values to a list, and maintain an index, when hasNext is called we check it with list's size, and if next is called we return the list value at index.

/**** Method 2 ****/
//Time Complexity: O(1)
//Space Complexity: O(h)

//Successfully submitted in LeetCode

//Rather than storing the all values in list we can use controlled recursion, we add the element left to root to the stack, when hasNext is called we return !stack.isEmptu(), and when next is called we pop the TreeNode in stack and check if has right if yes then we add the all elements to left of it to stack and return the pop element.

import java.util.ArrayList;
import java.util.Stack;

public class _173_Binary_Search_Tree_Iterator {

  /**** Method 1 ****/
  ArrayList<Integer> list;
  int index;

  public _173_Binary_Search_Tree_Iterator(TreeNode root) {
    list = new ArrayList<>();
    index = -1;
    fill(root);
  }

  public void fill(TreeNode root) {
    if (root == null) {
      return;
    }
    fill(root.left);
    list.add(root.val);
    fill(root.right);
  }

  /** @return the next smallest number */
  public int next() {
    return list.get(++index);
  }

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
    return index + 1 < list.size();
  }

  /**** Method 2 ****/
  Stack<TreeNode> stack;

  public _173_Binary_Search_Tree_Iterator(TreeNode root, int dummy) {
    stack = new Stack<>();
    dfs(root);
  }

  public int next1() {
    TreeNode popped = stack.pop();
    if (popped.right != null) {
      dfs(popped.right);
    }
    return popped.val;
  }

  public boolean hasNext1() {
    return !stack.isEmpty();
  }

  private void dfs(TreeNode root) {
    while (root != null) {
      stack.add(root);
      root = root.left;
    }
  }
}
