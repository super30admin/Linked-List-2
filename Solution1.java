// Leetcode Problem : https://leetcode.com/problems/binary-search-tree-iterator/description/
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * I use a stack to store all TreeNodes. In the constructor, I call dfs(root) where I store root as well as all 
 * left children of root. When next() is called, I pop root from stack. I call dfs on root.right and return 
 * root.val. When hasNext() is called, I return if the stack is not empty.
 */

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
        st= new Stack<>();
        dfs(root);
    }
    
    public int next() {
        TreeNode root = st.pop();
        dfs(root.right);
        return root.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }

    public void dfs(TreeNode root)
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