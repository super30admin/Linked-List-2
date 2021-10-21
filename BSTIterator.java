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
    TreeNode result;
    public BSTIterator(TreeNode root) {
    	//TODO: Since controlled recursion - check if recursive approach can be used with a implicit recursive stack?
        st = new Stack<TreeNode>();
        dfs(root);
    }
    
    public int next() {
        TreeNode result=st.pop();
        dfs(result.right);
        return result.val;
    }
    
    public boolean hasNext() {
       if(!st.isEmpty())
            return true;
        return false;
    }
    private void dfs(TreeNode root)
    {
        while(root!=null)
        {
            st.push(root);
            root=root.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */