// Iterators: LAZY LOADING: Controlled Recursion
// Space: O(h) for stack, where h is the height of the tree
class BSTIterator {
    Stack <TreeNode> st;
    public BSTIterator(TreeNode root) {
        this.st = new Stack<>();
        dfs(root);
    }

    private void dfs(TreeNode root){
        while(root!=null){
            st.push(root);
            root=root.left;
        }
    }
    
    public int next() { //O(h) for worst case, O(1) for Amortised
        TreeNode curr = st.pop();
        dfs(curr.right);
        return curr.val;
    }
    
    public boolean hasNext() { //O(1)
        return !st.isEmpty();
    }
}