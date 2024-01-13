/*
* Approach:
*  1. Iterators are for lazy loading, so we have to implement controlled recursion
    using iterative stack
* 
*  2. When we visit a node, push all its left childrens into stack.
        
    next() -> pop the element from the stack.
            while popping check if it has right childern,
            if it has, push all its left children into stack 
* 
*  3. hasNext() -> check whether stack is empty or not.
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(1) amortized
    because all leaf node -> 50% dont have to push any of the leaf childern.O(1)
    last but one node 25% -> has only one node to push O(1)

    amortized - O(1)
* 
* Space Complexity: O(h)
    h - height of the tree
* 
*/

import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> st;

    private void dfs(TreeNode root){
        while(root!=null){
            st.push(root);
            root = root.left;
        }
    }

    public BSTIterator(TreeNode root) {
        this.st = new Stack<>();
        dfs(root);
    }
    
    public int next() {
        TreeNode root = st.pop();
        
        dfs(root.right);

        return root.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}