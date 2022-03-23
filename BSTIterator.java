// Time Complexity : O(n), for hasNext and next functions its O(1)
// Space Complexity : O(n) 
class BSTIterator {

   Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        explore(root);
    }
    public void explore(TreeNode node){
        while(node != null){
            st.push(node);
            node = node.left;
        }
    }
    public int next() {
        TreeNode node = st.pop();
        explore(node.right);
            
        return node.val;
    }
    public boolean hasNext() {
        return !st.isEmpty();
    }
}
