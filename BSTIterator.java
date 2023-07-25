// Time Complexity : O(1) 
// Space Complexity : O(H), where H is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * 1. Maintain a stack of nodes, in inorder fashion.
 * 2. For next(), pop the top element from stack, and call dfs on its right child.
 * 3. For hasNext(), check if stack is empty.
 */

import java.util.Stack;

class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        dfs(root);
    }

    private void dfs(TreeNode root){ 
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode node = stack.pop();
        dfs(node.right);
        return node.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}