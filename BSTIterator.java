//Problem 52: Binary Search Tree Iterator
// Time Complexity : Amortized :O(1). Worst Case O(H), because only those nodes will be traversed
// Space Complexity : O(H), H stands for height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Steps: 1) Bruteforce: Create a linkedlist with the help of inorder traversal and then return and move the head node accordingly.
          Hoverver, iterator should not create a linkedlist or array as iterator should only bother about next or has next functions.
       2) Optimized: Use Concept of Contolled Recursion. Create a stack and push all the nodes at left of BST in the stack. While returning the next value just pop the element from the stack and then dfs on the popped elem.right. For checking hasNext() just return whether stack is emepty or not.
*/

import java.util.*;
class BSTIterator {

    //TC: O(1)-amortized, Worst Case:O(H)-->because stack is going to store/process max H elements and initially its going to be at constructor initialisation

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
          this.val = val;
        }
    }

    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        dfs(root);
    }
    
    public int next() {
        
        TreeNode root = stack.pop();
        dfs(root.right);
        return root.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    //push into root left stack until root is null 
    private void dfs(TreeNode root){
        
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
        
    }
}
