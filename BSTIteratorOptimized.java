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
    Stack<TreeNode> st = null;
    public BSTIterator(TreeNode root) {
    st = new Stack<>();
        helper(root);
    }
    
    private void helper(TreeNode root)
    {
        while(root !=null)
        {
            st.push(root);
            root = root.left;
        }
    }
    
    public int next() { //tc - o(1) - 75%, o(h)-25%
        TreeNode node = st.pop();
        helper(node.right);
        return node.val;
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