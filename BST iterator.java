// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

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
    //create a stack to hold the nodes
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        //intialize the stack
        st = new Stack<>();
        //call dfs on the root so that it goes all the way to the left most node
        dfs(root);
    }
    
    public int next() {
        //when you pop the elemnt at top of the stack check to see if it has a right that will be pushed on the stack and be the next element 
        TreeNode res = st.pop();
        dfs(res.right);
        return res.val;
    }
    
    public boolean hasNext() {
        //the only time we know that there is a next element is if our stack isn't empty, meaning the first element on top of the stack is the next element
        return !st.isEmpty();
    }
    
    private void dfs(TreeNode root){
        //iterate all the way left until root equals null
        while(root != null){
            //push root into stack and go left
            st.push(root);
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