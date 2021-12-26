// Time Complexity : O(1)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// Approach DFS

// Used a contolled recursive approach
// We take a stack 
// In the constructor we intialise the stack and we call the dfs 
// dfs function goes to the left while pushing the root to stack
// in the next method we pop the stack and do dfs for the right

class BSTIterator {
    Stack<TreeNode> s;

    public BSTIterator(TreeNode root) {
        s = new Stack<>();
        dfs(root);
    }

    public int next() {
        TreeNode popped = s.pop();
        dfs(popped.right);
        return popped.val;
    }

    public boolean hasNext() {
        return !s.isEmpty();
    }

    public void dfs(TreeNode root) {
        while (root != null) {
            s.push(root);
            root = root.left;
        }

    }
}