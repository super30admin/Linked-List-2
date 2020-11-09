//Time Complexity: O(n)
//Space Complexity: O(h) | h is the height of the tree
//Program ran successfully
/*
    Algorithm: 1. We perform a controlled a recursion. 
               2. A stack is maintained and the elements to the left of the root are pushed onto the stack.
               3. Once a next function call is made, we pop the top of the stack and check if there is a right node of the popped node.
               4. If there is a right node, we again push elements to the left of the root onto the stack
*/
class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        dfs(root);   
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode returnNode = st.pop();
        if(returnNode.right != null){
            dfs(returnNode.right);
        }
        return returnNode.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !st.isEmpty();
    }
    
    private void dfs(TreeNode root){
        while(root != null){
            st.push(root);
            root = root.left;
        }
    } 
}
