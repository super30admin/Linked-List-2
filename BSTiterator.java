// Time Complexity : O( max(maxNum, n) )
// Space Complexity : O( max(maxNum, n) )
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        DFS(root);
    }

    public int next() { // avg O(1), worst O(d)
        TreeNode result = st.pop();
        // left done, check right
        DFS(result.right);
        return result.val;
    }

    public boolean hasNext() { // O(1)
        return !st.isEmpty();
    }
    private void DFS(TreeNode root){
        while(root != null){ //store all Lefts
            st.push(root);
            root = root.left;
        }
    }
}
