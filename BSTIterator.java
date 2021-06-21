
class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        dfs(root);
    }

    // Time - worst: O(h)  avg: O(1)
    public int next() {
        TreeNode node = stack.pop();
        dfs(node.right);
        return node.val;
    }

    // Time - O(1)
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void dfs(TreeNode root){
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }
}