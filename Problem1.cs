// Time Complexity : O(n)
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
    private Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        st = new();
        TreeNode temp = root;

        PushLeftChildren(root);
    }
    
    public int Next() {
        TreeNode temp = st.Pop();
        
        if(temp.right != null)
        {
            PushLeftChildren(temp.right);
        }

        return temp.val;

    }
    
    public bool HasNext() {
        return st.Count > 0 ;
    }

    private void PushLeftChildren(TreeNode temp)
    {
        while(temp!=null)
        {
            st.Push(temp);
            temp = temp.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.Next();
 * bool param_2 = obj.HasNext();
 */