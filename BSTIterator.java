// Time Complexity : For next function, O(1), amortized case
// Space Complexity : O(h) where h is the height of the tree.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// To find the next min value, we need to find the leftmost value of the tree. If left node of the root is not present,
// we need to consider the left most value of right child. So we can keep all the left nodes in the stack by performing dfs on the root.
// For getting the next element we can pop from the stack. Now the popped element can also have nodes on its right, so we need to perform
// dfs on the popped element. With this push and pop strategy, we will be able to get the minimum node in the BST each time next is called.

import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        dfs(root);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode next = stack.pop();
        // traverse on right side of node
        dfs(next.right);
        return next.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void dfs(TreeNode node) {
        while (node.left != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
