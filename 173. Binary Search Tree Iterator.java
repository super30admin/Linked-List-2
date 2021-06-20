// Time complexity: O(n)
// Space complexity: O(n)
class BSTIterator {
    Stack<TreeNode> st = new Stack<>();
    
    public void findNext(TreeNode root){
        while (root!=null){
            st.push(root);
            root=root.left;
        }
    }

    public BSTIterator(TreeNode root) {
        findNext(root);
    }
    
    
    
    public int next() {
        TreeNode node = st.pop();
        int res = node.val;
        if (node.right!=null){
            node = node.right;
            findNext(node);
        } 
        return res;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}

