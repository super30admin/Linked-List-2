import java.util.*;

// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
public class BSTIterator {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) { // O(h)
        stack = new Stack();
        dfs(root);
    }

    public int next() {
        TreeNode root = stack.pop();
        dfs(root.right);
        return root.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void dfs(TreeNode root) {
        if (root == null)
            return;
        stack.push(root);
        dfs(root.left);
    }
}
