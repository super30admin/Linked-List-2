import java.util.*;

public class BSTIterator {
    Stack<TreeNode> s;

    public BSTIterator(TreeNode root) {
        s = new Stack<>();
        dfs(root);
    }

    public int next() {
        TreeNode root = s.pop();
        dfs(root.right);

        return root.val;
    }

    public boolean hasNext() {
        return !s.isEmpty();
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        s.push(root);
        dfs(root.left);
    }

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
}