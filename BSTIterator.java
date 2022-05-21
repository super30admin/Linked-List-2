// Time Complexity : O(1) amortized
// Space Complexity : O(N), N nodes in tree
// Did this code successfully run on Leetcode : on Geeks for Geeks yes
// Any problem you faced while coding this :

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
        stack = new Stack<TreeNode>(); // recursion stack
        
        leftMostInorder(root); 
    }
    
    private void leftMostInorder(TreeNode root){
        while (root != null){ // add all elements in leftmost branch of tree to stack
            stack.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode topNode = stack.pop();
        
        if (topNode.right != null){
            leftMostInorder(topNode.right); // need to obtain rightmost child
        }
        
        return topNode.val;
    }
    
    public boolean hasNext() {
        return stack.size() > 0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */