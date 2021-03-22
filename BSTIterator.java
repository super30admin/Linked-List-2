// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//push element and element.left to stack. 
//Pop element and check if the top of the stack has left subtree and if present push all of them
//if no LST or LST is traversed, then push Right subtree head and repeat the process

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
    
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        dfs(root);
        
        
    }
    
    private void dfs(TreeNode root){
        while(root != null){
            stack.push(root);
            root=root.left;
        }
    }
    
    public int next() {
        if(!hasNext())
            return -1;
        
        TreeNode root = stack.pop();
        dfs(root.right);
        
        return root.val;
        
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