// Time complexity - O(1)
// Space complexity - O(h)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
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
    
    Stack<TreeNode> s1;

    public BSTIterator(TreeNode root) {
        
            s1 = new Stack<>();
        dfs(root);
        
    }
    
    public int next() {
        
        TreeNode result = s1.pop();
        dfs(result.right);
        return result.val;
        
    }
    
    public boolean hasNext() {
        
        if(!s1.isEmpty()){
            
            return true;
        }
        
        return false;
        
    }
    
    private void dfs(TreeNode root){
        
        while(root != null){
            
            s1.add(root);
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