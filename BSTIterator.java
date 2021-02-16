// Time Complexity :O(n)
// Space Complexity :O(maxDepth)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach
class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {

        stack = new Stack<>();

        dfs(root);

    }

    private void dfs(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode root = stack.pop();

        dfs(root.right);

        return root.val;

    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}