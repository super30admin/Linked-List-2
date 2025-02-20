//TC: O(1) avg case, O(h) sometimes for next method
//SC: O(h)
//approach: recursive stack/DFS

import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode node = root;
        dfs(node);
    }

    public int next() {
        TreeNode node = stack.pop();
        dfs(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void dfs(TreeNode node){
        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }
}

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
