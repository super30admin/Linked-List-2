// Time Complexity : worst case : O(H) - Average O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes. Had to learn

/*
 * problem# 173
 * Controlled iterations; We will have a custom stack- 
 * we put all left nodes into stack & when ever we pop a node from stack - > read the right subnode and add it to stack.
 * 
 * if stack is empty then we have no next elements
 * 
 * Iterators are thread safe & we don't know the size of the list.
 * 
 * Indesign problems we will consider average time complexity.
 * 
 * In a BST-
 * 
 * Half of the nodes will be in the leaf nodes -> n/2
 * One level above the leaf nodes -> n/4
 */

import java.util.*;

public class BSTIterator {

    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        init(root);

    }

    private void init(TreeNode root) {
        while (root != null) {
            stack.add(root);
            root = root.left; // traverse left tree
        }

    }

    public int next() {
        TreeNode curr = stack.pop(); // Inorder traversal
        init(curr.right);
        return curr.val;

    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}