// Time Complexity : O(H)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Y
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
Use inorder travesal - Iterate to leftmost node, pop, check right to iterate, return value. Repeat

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




    Deque<TreeNode> stack = new LinkedList<TreeNode>();

    public BSTIterator(TreeNode root) {
        dfs(root);
    }

    public void dfs(TreeNode root){
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode root = stack.pop();
        dfs(root.right);
        return root.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}