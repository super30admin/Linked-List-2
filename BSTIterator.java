// Time Complexity : O(1)
//Space Complexity : O(h) 
//Did this code successfully run on Leetcode : Yes

class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack();
        bst(root);
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode node = st.pop();
        bst(node.right);
        return node.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(!st.isEmpty()) {
            return true;
        }
           else
           {
               return false;
           }
    }
    
    private void bst(TreeNode root){
        while(root != null){
            st.push(root);
            root = root.left;
        }
    }
}