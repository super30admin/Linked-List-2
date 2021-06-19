class BSTIterator {
    Stack<TreeNode> s;

    //dfs call only for left
    public void dfs(TreeNode root) {
        while(root != null) {
            s.push(root);
            root = root.left;
        }
    }
    public BSTIterator(TreeNode root) {
        s = new Stack<>();
        dfs(root);
    }

    public int next() {
        TreeNode node = s.pop();
        dfs(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return !s.isEmpty();
    }
}