/**LC-173 Design Problem. 
 * 
 * Time Complexity : O(1) 
 * Space Complexity : O(H) H: Height of the tree
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 *
 Algorithm: Main idea, keep the next element on the top of the stack always
 1. In the constructor itself, put each node from root to the left most bottom element, which is the smallest elememt
 2. When next() function is called, pop the top value. Pop happens when the top element does not has left child
 3. Now do the same left recursion to the right side of the popped element (if the popped element has a right side)
 
 While finding the space and time complexity, we don't bother about the constructor since it is not user centric.
 and also called only once. User is not going to use the constructor, user will use next() and hasNext()

 hasNext() -> O(1)
 next() Average O(1) ...when we removed the 1 it didn't had right child, at that time the time complexity was O(1)
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
class BSTIterator {
    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        
        st = new Stack<>();
        dfs(root); 
    }
    
    /** @return the next smallest number */
    public int next() {
        
        TreeNode returnedNode = st.pop();  //O(1)
        if(returnedNode.right != null){
            dfs(returnedNode.right);
        }
        return returnedNode.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !st.isEmpty();    //O(1)
    }
    
    private void dfs(TreeNode root){
        
        while(root != null){
            
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