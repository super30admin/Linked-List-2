package S30.LinkedList2;

import java.util.Stack;

/*Controlled Recursion
Time Complexity : O(1) - average time complexity for next function and O(1) for hasnext function
Space Complexity : O(h), O(n) is tree is skewed
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

public class BSTIterator {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode current = root;
        while(current != null){
            stack.push(current);
            current = current.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode nextNode = stack.pop();
        if(nextNode.right != null){
            TreeNode current = nextNode.right;
            while(current != null){
                stack.push(current);
                current = current.left;
            }
        }

        return nextNode.val;

    }

    /** @return whether we have a next smallest number */
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

