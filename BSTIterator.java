class BTSIterator {

    //O(n) space for number of nodes in the tree
    //O(1) for hasNext and O(n) for next in terms of time
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode node = root;
        dfs(node);
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        TreeNode node = stack.pop();
        dfs(node.right);
        return node.val;
    }

    private void dfs(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }


}