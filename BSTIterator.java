/*
Approach : Here we use our own stack and push all treenode using dfs
in an inorder traversal
Before returning the root or top of stack we process the right subtree and left node of right
subtree first of all.
we can also process data on-demand
adding a dynamic ability of future data as much as possible.
 */

// Time: O(1) amortized per next() / hasNext() call.
// Space: O(h) stack stores path from root to leaf.



class BSTIterator {
    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        this.st = new Stack<>();
        dfs(root);
    }

    private void dfs(TreeNode root){
        while(root != null){
            st.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode temp = st.pop();

        dfs(temp.right);

        return temp.val;
        
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}