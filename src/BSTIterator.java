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

// Time Complexity: O(n)
// Space Complexity: O(n+h)

class BSTIterator {
    
    private Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        explore(root);
    }
    
    // Time Complexity: O(1)
    public int next() {
        TreeNode node = stack.pop();                // left child would have been processed
        
        // completing left child chain, process right child's left child chain which will be very next node
        explore(node.right);
        
        return node.val;
    }

    // Time Complexity: O(1)    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    private void explore(TreeNode node) {
        // adding all left elements in chain
        while(node != null) {
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
