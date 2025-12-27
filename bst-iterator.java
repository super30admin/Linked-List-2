// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        this.st = new Stack<>();
        dfs(root);
    }

    private void dfs(TreeNode curr){
        while(curr !=null){
            st.add(curr);
            curr = curr.left;
        }
    }
    
    public int next() { //amortized O(1)
        TreeNode result = st.pop();
        dfs(result.right); //only add the next node when the prev node is removed.
        return result.val;
    }
    
    public boolean hasNext() { //O(1)
        return !st.isEmpty();
    }
}
