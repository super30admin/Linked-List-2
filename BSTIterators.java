// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


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
    Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        dfs(root);
    }

    // takes O(Height of the tree) worst case, else O(1) on average
    public int next() {
        TreeNode returnVal = stack.pop();
        dfs(returnVal.right);
        return returnVal.val;
    }
    // takes O(1) time
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    // to find the leftmost bottom node due to the constraint in-order traversal
    private void dfs(TreeNode root) {
        TreeNode curr = root;
        while(root!=null) {
            stack.add(root);
            root = root.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */