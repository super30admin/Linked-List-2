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
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
// Your code here along with comments explaining your approach
//perform dfs and store nodes in a stack, pop them when next is called and then perfrom dfs on the right elments 
// of the popped node, in hasnext we need to check the stackempty and return boolean accordingly.
class BSTIterator {
    Stack<TreeNode> s;
    public BSTIterator(TreeNode root) {
       s= new Stack<>(); 
        dfs(root);
    }
    
    public int next() {
        TreeNode popped= s.pop();
        dfs(popped.right);
        return popped.val;
    }
    
    public boolean hasNext() {
        return !s.isEmpty();
    }
    private void dfs(TreeNode root){
       while(root!=null){
           s.push(root);
           root=root.left;
       }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */