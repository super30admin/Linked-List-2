// Time Complexity : O(n) for constructor due to full traversal, O(1) for each next() and hasNext().
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
// Use a stack to simulate inorder traversal of the BST.
// Always push the leftmost path so the smallest element is on top.
// On next(), pop the node and process its right subtree.

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
    Stack<TreeNode> St;

    public BSTIterator(TreeNode root) {
        St =  new Stack<>();
        dfs(root);
    }
    private void dfs(TreeNode root){
        while (root != null){
            St.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode temp = St.pop();
        dfs(temp.right);
        return temp.val;
        
    }
    
    public boolean hasNext() {
        return St.size() >0;
        
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */