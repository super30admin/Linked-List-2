// Time Complexity :o(n)
// Space Complexity : o(h)
// Did this code successfully run on Leetcode :  yes
// Any problem you faced while coding this : no
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
    Stack<TreeNode> st = new Stack<>();
    public BSTIterator(TreeNode root) {
        search(root);
    }
    
    public int next() {
        TreeNode res = st.pop();
        search(res.right);
        return(res.val);
    }
    
    public boolean hasNext() {
        if(!st.isEmpty())
            return true;
        else
            return false;
    }
    private void search(TreeNode root)
    {
        if(root == null) return;
        st.push(root);
        search(root.left);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */