// Time Complexity : O(1)
// Space Complexity : O(n)
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
        st = new  Stack<>();
        // call recursive dfs function with root
        dfs(root);
    }
    
    public int next() {
        // to return the next element, pop the stack and
        // perform dfs on on right child of the popped node
        TreeNode node = st.pop();
        dfs(node.right);
        return node.val;
    }
    
    public boolean hasNext() {
        // check for empty stack 
        return !st.isEmpty();
    }
    
    private void dfs(TreeNode root){
        // keep pushing left nodes in stack until leaf node is found
        while(root != null){
            st.push(root);
            root  = root.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */