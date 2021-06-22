//time complexity:O(1)
//space complexity:O(n)
class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st=new Stack<>();
        dfs(root);//initially we reach to the left end of the 
        //tree
    }
    
    public int next() {
        TreeNode node=st.pop();//we then pop the element(s)
        dfs(node.right);//and then we reach the node on the right
        return node.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
    private void dfs(TreeNode root)
    {
        while(root!=null)
        {
            st.push(root);
            root=root.left;
        }
    }
}
