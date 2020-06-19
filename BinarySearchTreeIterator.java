// Time Complexity : O(1) , worst case O(h)
// Space Complexity : O(h), height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :



//iterator has access to next node only.
//all nodes are not added to stack at first. 
//nodes are added when function is called
class BSTIterator {
    //declare stack globally
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        //initialize the stack
        st = new Stack<>();
        //call method to insert nodes to stack
        stackinsert(root);        
    }
    
    /** @return the next smallest number */
    //method to pop top node from stack
    public int next() { 
        //root.left < root < root.right : so left popped first, then root, then root.right
        //note top element and pop
        //call right of top to add to stack, if non return top val 
        //next time : new top of stack is popped and checked for top.right
        TreeNode top = st.pop();
        stackinsert(top.right);
        return top.val;
        
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        //check if stack is empty, if empty no next node, else stack as next node
        if(!st.isEmpty()) {
            return true;
        }
        return false; 
        
    }
    
    private void stackinsert(TreeNode root) {
        //return type void, as we only need to add nodes to stack, 
        //we can access stack (global declaration)
        //add root.left until root = null (to add nodes in decending sequence) (as root.left < root)
        while(root != null) {
            st.push(root);
            root = root.left; 
        }
        
    }
}


