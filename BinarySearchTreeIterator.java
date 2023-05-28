// Time Complexity :
//      O(1) for hasNext
//      O(1) (amortized) otherwise O(h) for next()
// Space Complexity : O(h)

class BSTIterator {

    Stack<TreeNode> s;
    public BSTIterator(TreeNode root) {
        s = new Stack<>();
        dfs(root);
    }

    private void dfs(TreeNode root) {
        while(root != null) {
            s.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode popped = s.pop();
        dfs(popped.right);
        return popped.val;
    }

    public boolean hasNext() {
        return !s.isEmpty();
    }
}