// Time Complexity : O(n) for initialization, O(1) for next and hasNext
// Space Complexity : O(n) for storing the elements in a queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: Use a stack to perform an in-order traversal of the BST and store the elements in a queue.
// The next() method will return the front element of the queue, and hasNext() will check if the queue is not empty.

import java.util.*;

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
    Queue<Integer> queue;
    public BSTIterator(TreeNode root) {
        queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root!=null){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            queue.add(root.val);
            root = root.right;
        }
    }
    
    public int next() {
        return queue.poll();
    }
    
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */