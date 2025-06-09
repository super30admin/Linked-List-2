// Time Complexity :
// - next(): O(1) amortized time per operation
// - hasNext(): O(1)

// Space Complexity : O(h), where h is the height of the tree
// - Because the stack stores at most h nodes at any time

// Did this code successfully run on Leetcode : Yes

class BSTIterator {
    private Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        dfs(root);
    }
    private void dfs(TreeNode root){
        while(root != null){
            st.push(root);
            root = root.left;
        }
    }
    public int next() {
        TreeNode pop = st.pop();
        dfs(pop.right);
        return pop.val; 
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}
