/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class BSTIterator {
    Stack<TreeNode> st = new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        dfs(root);    
        
    }
    void dfs(TreeNode root)
    {
        while(root!=null)
        {
            st.Push(root);
            root = root.left;
        }
    }
    
    public int Next() {
        if(st.Count>0)
        {
            TreeNode node = st.Pop();
            dfs(node.right);
            return node.val;
        }
        return 0;
        
    }
    
    public bool HasNext() {
        if(st.Count>0)
        {
            return true;
        }
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.Next();
 * bool param_2 = obj.HasNext();
 */