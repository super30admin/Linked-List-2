/*
 * #173. Binary Search Tree Iterator
 * 
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

 

Example:
Refer from leetcode


BSTIterator iterator = new BSTIterator(root);
iterator.next();    // return 3
iterator.next();    // return 7
iterator.hasNext(); // return true
iterator.next();    // return 9
iterator.hasNext(); // return true
iterator.next();    // return 15
iterator.hasNext(); // return true
iterator.next();    // return 20
iterator.hasNext(); // return false
 

Note:

1. next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
2. You may assume that next() call will always be valid, that is, there will be at least a next smallest number in the BST when next() is called.

 */


/*
 * 1. Iterative Approach:
 * 
 * next(): O (maxDepth)
 * 
 * hasNext(): O (1)
 * 
 * Space Complexity: O (maxDepth)
 * 
 * 2. Recursive Approach:
 * 
 * next(): O (1)
 * 
 * hasNext(): O (1)
 * 
 * Space Complexity: O (N) + O (N) -> O (2N) -> O (N)
 * 									// O (N) -> Recursive stack space
 * 									// O (N) -> Array to store 'N' next smallest numbers in a tree
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.linkedlist2;

import java.util.Stack;

//Definition for a binary tree node.
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

/*
* #1. Create a stack to store the next smallest numbers in a tree
* #2. Create an iterator
* #3. Call to next()
*       - pop the top element from stack
        - check if popped.right exists
            - If yes, call dfs(popped.right) -> #2. step
                - meaning, go to the leftmost child of popped.right 
                  to get the next smallest number 
            - If not, return the popped value(next smallest element)
              or return popped value, if we are done traversing popped.right element
*/
public class BSTIterator {
	// #1.
    Stack<TreeNode> stack;
    
    public BSTIterator(TreeNode root) {
        // #1. 
        stack = new Stack<>();
        // #2.
        dfs(root);
    }
    
    /** @return the next smallest number */
    public int next() {
        // In question, we are given that next() is always valid
        // But when its not, before popping element from stack we have to check if stack is not empty
        if(!hasNext()){
           return -1; // stack is empty now 
        }
        // Else
        // On the call to next(), pop the next smallest element(top) from stack
        
        // #3. 
        TreeNode popped = stack.pop();
        
        // Check if right of popped element exists
        // If yes, then call dfs on the right element, to go to its lefmost child to get next smallest number
        if(popped.right != null){
            dfs(popped.right);
        }
        
        // return the popped element if popped.right does not exist or we are done traversing its right child 
        return popped.val;
        
    }
    
    /** @return whether we have a next smallest number */
    /*Whether the stack is empty or not*/
    public boolean hasNext() {
        // return true is stack is not empty
        // If we have next smallest number in stack
        return !stack.isEmpty();
        
    }
    
    // #2.
    // Inorder traversal
    // Traverse to the leftmost child of a root
    // When the left child is null, control goes back to calling function(next() function) and popped element is returned as next smallest number
    public void dfs(TreeNode root){
        while(root != null){
            stack.add(root);
            root = root.left;
        }   
    }
    
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
