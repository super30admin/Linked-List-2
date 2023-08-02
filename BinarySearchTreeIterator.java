// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.util.Stack;

class BinarySearchTreeIterator {

    private Stack<TreeNode> st;

    public BinarySearchTreeIterator(TreeNode root)
    {
        this.st= new Stack<>();
        dfs(root);

    }

    private void dfs(TreeNode root)
    {
        while(root!=null)
        {
            st.push(root);
            root=root.left;
        }
    }

    public int next()
    {
        // Initially, we remove the element from the stack and subsequently investigate if there are any elements present on the left side of the right subtree through a recursive DFS approach.
        TreeNode curr=st.pop();
        dfs(curr.right);
        return curr.val;
    }

    //Check if the stack is empty
    public boolean hasNext()
    {
        return (!st.isEmpty());
    }
}