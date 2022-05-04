import java.util.Stack;

public class Problem1 {
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

    // TC : O(1)
    // sc : O(h)
    class BSTIterator {
        Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            dfs(root);
        }

        public int next() {
            TreeNode result = stack.pop();
            dfs(result.right);
            return result.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        private void dfs(TreeNode root) {
            while (root != null) {
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
}
