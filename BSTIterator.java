// Time Complexity : O(1), for next and hasNext
// Space Complexity : O(h), where h is the height of the tree (stack space)
// Did this code successfully: Yes
// Any problem you faced while coding this : No

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

    private void dfs(TreeNode node) {
        while(node!= null){
            stack.push(node);
            node = node.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */