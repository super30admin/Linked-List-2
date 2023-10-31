
public class BSTIterator {
    Stack<TreeNode> st = new Stack();
    public BSTIterator(TreeNode root)
    {
        dfs(root);
    }

    public int next()
    {
        TreeNode popped = st.peek();
        st.pop();
        if(popped.right != null)
            dfs(popped.right);

        return popped.val;
    }

    public boolean hasNext()
    {
        return !st.isEmpty();
    }

    public void dfs(TreeNode root)
    {
        while(root!= null)
        {
            st.add(root);
            root = root.left;
        }
    }
}
