// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//O(1)
//O(1)
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
Stack<TreeNode> stack = new Stack <TreeNode>();
//int count = 0;
    public BSTIterator(TreeNode root) {
        
        dfs(root);
    }
    private void dfs(TreeNode root){
        while(root != null){
            stack.push(root);
            root = root.left;
            }
    }   
   
    public int next() {
        if(!hasNext()){
            return -1;
        }
        //PrintStack(stack);
        TreeNode root = stack.pop();
        dfs(root.right);
        return root.val;
    }
    
    public boolean hasNext() {
        return !(stack.isEmpty());
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */