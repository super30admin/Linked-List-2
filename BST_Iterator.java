// Time Complexity : O(h) will be the runtime of dfs and next  and O(1) for hasnext
// Space Complexity :O(h) where h is the height of stack at any point 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

// dfs function --> adds the path from given root to the bottom left leaf.
// we do dfs when instantiating
//next() --> when we pop put any element from stack we do dfs (popped.right) to add the intermediate nodes and return popped.val
//hasnext() --> simply see if the stack is empty or not

class BSTIterator {
    private Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        st = new Stack();
        dfs(root);
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode popped = st.pop();
        if (popped.right != null)
            dfs(popped.right);

        return popped.val;

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (st.isEmpty())
            return false;
        return true;
    }

    private void dfs(TreeNode root) {
        while (root != null) {
            st.push(root);
            root = root.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such: BSTIterator
 * obj = new BSTIterator(root); int param_1 = obj.next(); boolean param_2 =
 * obj.hasNext();
 */