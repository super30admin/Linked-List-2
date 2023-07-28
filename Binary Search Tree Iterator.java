
 // Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// We will follow controlled recursion here. We will maintain a stack and push all the left nodes of the tree until it encounters a null node. Then when we check for the next node, in its respective function, we check for the right node. 
//We are doing inorder traversal, hence the sequence is Left-Root-Right. When a next node is checked, we pop the top most element in the stack and for the hasNext function we check if the stack is not empty. 
//If not, then there are nodes to be returned, otherwise we return false.

 class BSTIterator {

    private Stack<TreeNode> st;

    public BSTIterator(TreeNode root) 
    {
        this.st= new Stack<>();
        dfs(root);
  
    }

    private void dfs(TreeNode root)
    {
        while(root!=null)
        {
            st.push(root);
            root=root.left; 
        }
    }
    
    public int next() 
    {
        //First we pop the element in the stack and then check if there is any element on the right side's left nodes by doing a dfs recursion there
        TreeNode curr=st.pop();
        dfs(curr.right);
        return curr.val;
    }
    
    //Check if the stack is empty
    public boolean hasNext() 
    {
        return (!st.isEmpty());
    }
}
