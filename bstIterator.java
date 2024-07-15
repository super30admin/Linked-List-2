// Time Complexity : O(1)AmortizedForNext,O(1)ForHasnext
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


class BSTIterator {
    Stack<TreeNode> st;

    // Constructor initializes the stack and performs DFS to add leftmost nodes
    public BSTIterator(TreeNode root) {
        this.st = new Stack<TreeNode>();
        dfs(root); // Initialize the stack with the leftmost path from the root
    }

    // Helper function to perform DFS and push all left children of a subtree onto the stack
    private void dfs(TreeNode root) {
        if (root == null) return; // Base case: if the node is null, return
        st.add(root); // Add the current node to the stack
        dfs(root.left); // Continue with the left child
    }

    // Return the next smallest element in the BST
    public int next() {
        TreeNode node = st.pop(); // Pop the top node from the stack (smallest element)
        dfs(node.right); // Perform DFS on the right subtree of the popped node
        return node.val; // Return the value of the popped node
    }

    // Check if there are more elements in the BST iterator
    public boolean hasNext() {
        return !st.empty(); // Return true if the stack is not empty, false otherwise
    }
}
