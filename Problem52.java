// Time Complexity : amortized O(1)
// Space Complexity : O(h)

class BSTIterator {
    private Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        dfs(root);
    }

    private void dfs(TreeNode root) {
        if (root != null) {
            this.stack.push(root);
            dfs(root.left);
        }
    }
    
    public int next() {
        TreeNode temp = this.stack.pop();
        dfs(temp.right);
        return temp.val;
    }
    
    public boolean hasNext() {
        return !this.stack.isEmpty();
    }
}