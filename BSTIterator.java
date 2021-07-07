// Time Complexity : O(n)
// Space Complexity : O(1) in average case; O(h) in worst case; h--> height of BST
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// To return the next smallest number in BST, we need to perform inorder traversal. 
// I am taking a stack which will keep track of all the left children recursively. Whenever a leaf node is encountered, it means that the smallest element has been found.
// To get required element in next method call, the smallest number will be popped from stack and the right children of that node will be explored recursively.
// This process will ensure that a controlled recursion is happening and in average case number of elements in stack will be constant.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        dfs(root);
    }
    
    /** @return the next smallest number */
    public int next() {
        if(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            dfs(node.right);
            return node.val;
        }
       return 0; 
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    private void dfs(TreeNode root) {
        if(root == null) return;
        stack.push(root);
        dfs(root.left);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

