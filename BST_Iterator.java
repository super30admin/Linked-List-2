// Time Complexity for next(), hasNext(): O(1) ; dfs: O(h)
// Space Complexity next(), hasNext(): O(1), dfs: O(h)
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
    private Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
     this.st = new Stack<>();
      dfs(root);
    }
    
    public void dfs(TreeNode root){
        while(root!=null){
            st.push(root);
            root= root.left;   
        }   
    }
    
    
    public int next() {
        TreeNode ele = st.pop();
        dfs(ele.right);
        return ele.val;
        
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
