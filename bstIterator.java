// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

public class bstIterator {

    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        st=new Stack<TreeNode>();
        dfs(root);
    }
    
    public int next() {
        TreeNode result=st.pop();
        dfs(result.right);
        return result.val;
        
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
    
    private void dfs(TreeNode root){
        while(root!=null){
            st.push(root);
            root=root.left;
        }
        
        
    }
    
}
