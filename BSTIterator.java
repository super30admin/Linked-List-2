// Time Complexity : O(N) 
// Space Complexity : o(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
used iterative approach and used stack to push all the left elements, when next() function is called popped the stack and returned the value. To check hasnext(), verified if stack is empty or not
class BSTIterator {
    
    Stack<TreeNode> bst = new Stack<>();

    public BSTIterator(TreeNode root) {
        dfs(root);
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode nextval=bst.pop();
        if(nextval.right!=null){
            dfs(nextval.right);
        }
            return nextval.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !bst.isEmpty();
    }
    
    public void dfs(TreeNode root){
        while(root!=null){
            bst.add(root);
            root=root.left;
        }
    }
}
