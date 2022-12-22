// Time Complexity : O(1)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

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
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        this.st = new Stack<TreeNode>();
        dfs(root);
    }

    private void dfs(TreeNode root)
    {
        while(root != null)
        {
            st.Push(root);
            root = root.left;
        }

        
    }
    
    public int Next() {
        TreeNode result = st.Pop();
        dfs(result.right);
        return result.val;
    }
    
    public bool HasNext() {
        return st.Any();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.Next();
 * bool param_2 = obj.HasNext();
 */
