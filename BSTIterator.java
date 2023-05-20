// Time Complexity :
//      O(1) for hasNext
//      O(1) (amortized) otherwise O(h) for next()
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

/*
 * Approach:
 * We use a stack to keep track of all the left side elements of the BST.
 * Once the next() function is called, we return the top of stack, but we
 * also push the right child and all the next left elements of the stack.
 * hasNext() just returns whether the stack is empty or not (since that
 * contains) the next elements.
 */

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
import java.util.*;
class BSTIterator {

    Stack<TreeNode> s;
    public BSTIterator(TreeNode root) {
        s = new Stack<>();
        dfs(root);
    }

    private void dfs(TreeNode root) {
        while(root != null) {
            s.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode popped = s.pop();
        dfs(popped.right);
        return popped.val;
    }
    
    public boolean hasNext() {
        return !s.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */