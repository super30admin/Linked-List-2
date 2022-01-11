// Time Complexity :
// next : Amortized O(1) and worst case : O(h) 
// (h : height of the tree and for skew tree it is O(n))
// hasNext : O(1)

// Space Complexity : O(h) (h : height of the tree and for skew tree it is O(n))

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

    // Create a stack to store the nodes 
    Stack<TreeNode> stack = new Stack<>();
    
    public BSTIterator(TreeNode root) {
        
        // Traverse the tree : Left operation
        dfs(root);
        
    }
    
    public int next() {
        
        TreeNode root = stack.pop();
        
        dfs(root.right);
        
        return root.val;
    }
    
    public boolean hasNext() {
        
        return !stack.isEmpty();
    }
    
    private void dfs(TreeNode root){
        
        
        // reached leaf node
        if (root == null){
            return;
        }
        
        stack.push(root);
        
        // Move towards left
        dfs(root.left);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */