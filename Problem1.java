// Time Complexity : O(n)
// Space Complexity : O(h) f
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//we initially push only the left side of the tree onto the stack.
// The remaining elements are loaded lazily: when the next() operation is invoked,
// an element is popped out, and the depth-first search (DFS) for its right subtree is initiated
// and pushed into the stack.

public class Problem1 {
    private Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        this.st = new Stack<>();
        dfs(root);
    }

    private void dfs(TreeNode root){
        while(root!=null){
            st.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode curr = st.pop();
        dfs(curr.right);
        return curr.val;
    }

    public boolean hasNext() {
        return (!st.isEmpty());
    }
}