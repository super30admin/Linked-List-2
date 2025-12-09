/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// Approach: Using Stack
// Time: O(1)
// Space: O(h) for stack
class BSTIterator {
    private Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        // store nodes in the stack such that next node is always on top
        this.stack = new Stack<>();
        dfs(root);
    }

    private void dfs(TreeNode root) {
        // Inorder returns left nodes first. Reach end of left nodes.
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        // top element of stack is the next element
        TreeNode next = stack.pop();

        // store dfs of right child before return
        dfs(next.right);

        return next.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */