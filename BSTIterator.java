
// Time complexity : next() function : O(h) , hasNext() : O(1)
// Space complexity : O(h)
import java.util.Stack;

class TreeNode {
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

public class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        dfs(root);
    }

    private void dfs(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode curr = stack.pop();
        dfs(curr.right);
        return curr.val;
    }

    public boolean heasNext() {
        return !stack.isEmpty();
    }
}
