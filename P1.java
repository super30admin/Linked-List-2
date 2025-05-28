/*
Method	       Time	                Space
Constructor	    O(h)	             O(h) stack
next()	      Amortized O(1)	    O(h) at most
hasNext()	    O(1)	                 —

where h is the height of the tree.
 */


class BSTIterator {
    private Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        this.st = new Stack<>();
        dfs(root);    
    }

    private void dfs(TreeNode root) {
        while (root != null) {
            this.st.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode res = st.pop();
        dfs(res.right);
        return res.val;
    }
    
    public boolean hasNext() {  //O(1)
        return !st.isEmpty();
    }
}