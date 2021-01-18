//https://leetcode.com/problems/binary-search-tree-iterator/
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : YES

class BSTIterator {
    Stack<TreeNode> s = new Stack<>();

    public BSTIterator(TreeNode root) {
        dfs(root);
    }

    // Time Complexity : O(h)
    public int next() {
        TreeNode t = s.pop();
        dfs(t.right);
        return t.val;
    }

    // Time Complexity : O(1)
    public boolean hasNext() {
        return !s.isEmpty();
    }

    // Time Complexity : O(h)
    public void dfs(TreeNode root) {
        while (root != null) {
            s.push(root);
            root = root.left;
        }
    }
}