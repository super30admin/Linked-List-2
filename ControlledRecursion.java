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
// Time Complexity : O(1)
// Space Complexity : O(h) where h is the height of the tree for stack
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :nopes
class ControlledRecursion {

    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {

        st=new Stack<>();
        dfs(root);

    }

    /** @return the next smallest number */
    public int next() {

        TreeNode returnNode = st.pop();

        if(returnNode.right!=null)
            dfs(returnNode.right);

        return returnNode.val;

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !st.isEmpty();
    }

    private void dfs(TreeNode root)
    {
        while(root != null)
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