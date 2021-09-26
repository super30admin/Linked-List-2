// Time Complexity : O(1) 
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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

    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack<>(); //stack used to store elements
        dfs(root); //calling dfs method for the first time inside constructor
    }
    
    public int next() { 
        TreeNode result = st.pop(); //whatever is on top of the stack
        dfs(result.right); //recursion called by passing right of popped element
        return result.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty(); //returns true as long as there's something in stack
    }
    
    private void dfs(TreeNode root) { //defining dfs here
        while(root != null) { //null check
            st.push(root); //putting TreeNode passed to dfs inside the Stack
            root = root.left; //changing root to root.left
            //because left element is smaller
        }
        
    }
    
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */