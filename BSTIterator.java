class BSTIterator {

    Stack <TreeNode> st;

    public BSTIterator(TreeNode root) {

        st = new Stack<>();

        TreeNode node = root;

        dfs(node);

    }

    

    /** @return the next smallest number */

    public int next() {

        TreeNode node = st.pop();

        dfs(node.right);

        return node.val;

    }

    

    /** @return whether we have a next smallest number */

    public boolean hasNext() {

        return !st.isEmpty();

    }

    private void dfs(TreeNode node){

        while(node != null){

            st.push(node);

            node = node.left;

        }

    }

}
