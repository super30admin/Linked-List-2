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

// Time Complexity = amortized O(1)
// Space Complexity = O(1)

class BSTIterator {
    private Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack();
        dfs(root);
    }
    
    private void dfs(TreeNode root){
        while(root!= null){
            st.push(root);
            root = root.left;
        }
    }
    
    public int next() { //O(H)
        TreeNode next = st.pop();
        dfs(next.right);
        return next.val;
        
    }
    
    public boolean hasNext() { //O(1)
        return !st.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */