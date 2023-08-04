// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.util.Stack;

class BinarySearchTreeIterator {

    private Stack<TreeNode> st; // Declare a stack to store tree nodes

    public BinarySearchTreeIterator(TreeNode root)
    {
        this.st= new Stack<>(); // Initialize the stack
        dfs(root); // Perform a Depth-First Search (DFS) to push all left nodes into the stack

    }

    private void dfs(TreeNode root)
    {
        while(root!=null)
        {
            st.push(root); // Push the current node into the stack
            root = root.left; // Move to the left child of the current node
        }
    }

    public int next()
    {
        TreeNode curr=st.pop(); // Remove the top node from the stack, representing the next element in the in-order traversal
        dfs(curr.right); // Perform a DFS on the right child of the removed node to explore its left nodes
        return curr.val; // Return the value of the removed node
    }

    // Check if the stack is empty, which indicates if there is any next element in the in-order traversal
    public boolean hasNext()
    {
        return (!st.isEmpty());
    }
}
