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

 /* Time Complexity :
 * 	overall - O(n)
 *  n - no. of nodes of the tree
 *  next(), hasNext() - O(1)
 * */

/* Space Complexity :
 * 	overall - O(h)
 *  h - height of the tree
 *  next(), hasNext() - O(1)
 * */
 
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :

class BSTIterator {
    private Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        dfs(root);
    }
    
    private void dfs(TreeNode root){
        while(root != null){
            st.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode popped = st.pop();
        dfs(popped.right);
        return popped.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */