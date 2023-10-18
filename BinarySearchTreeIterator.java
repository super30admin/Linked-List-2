public class BinarySearchTreeIterator {
    java.util.Stack<TreeNode> stack;

    public BinarySearchTreeIterator(TreeNode root) {
        stack = new java.util.Stack<>();
        dfs(root);

    }

    public int next() {
        TreeNode popped = stack.pop();
        dfs(popped.right);
        return popped.val;
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
