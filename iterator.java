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
        st=new Stack<>();
        dfs(root);
    }
    
    public int next() {
        TreeNode res=st.pop();
        dfs(res.right);
        return res.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
    public void dfs(TreeNode root){
        while(root!=null){
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