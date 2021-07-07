package com.ds.rani.tree;

import java.util.Stack;


//Approach: first only add left elements in the stack,when root becomes null pop the value from stack
// and return it for next() and call DFS on removed nodes right node.

//Time complexity for next() and hasNext():o(1)
//Space complexity :o(h) where h is geight of the tree
public class BSTIterator {

    /**
     * TreeNode class
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        //push all the left elements in stack
        DFS( root );
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        //next value is always top value from the stack
        TreeNode nxt = stack.pop();
        //call  DFS on its right
        DFS( nxt.right );
        return nxt.val;

    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        if (stack.isEmpty())
            return false;
        else
            return true;

    }

    void DFS(TreeNode root) {
        while (root != null) {
            stack.push( root );
            root = root.left;
        }
    }
}

