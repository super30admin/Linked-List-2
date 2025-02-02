// Time Complexity : O(1)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : yes
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
    // TC = O(1), SC = O(H)
    public Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack<>(); // creating own stack rather thna rec st for controlled rec
        dfs(root);
    }
    private void dfs(TreeNode root) {
        while(root != null) { // Calling root.left till root != null, no recursive call, using while loop instead, just like iterative implementation of inorder BST
            st.push(root);
            root = root.left;
            }
    }
    
    public int next() { // O(1) as in line 34, >75% it is O(1)
        TreeNode curr = st.pop();
        int val = curr.val;
        dfs(curr.right); // calling right only when left is finished (null) for controlled recursion
        return val;
    }
    
    public boolean hasNext() { // O(1)
        return !st.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */