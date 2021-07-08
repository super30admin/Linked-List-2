// Time Complexity : next() -> O(1), hasNext -> O(1)
// Space Complexity : O(1) Dont use additional DS here
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Controlled Recursion
/* Your code here along with comments explaining your approach: Stack will keep a track of all the nodes and its easy to control your recursion using a stack.
when next is called, reach the left most node in BST to get the min. Pop the node, and do a DFS on the right child if exists, to get the next minimum 
in future. For hasNext(), simply check if the stack has any node to display or is it empty (means no next node).
*/
class BSTIterator {
    Stack<TreeNode> stk;
    public BSTIterator(TreeNode root) {
        stk = new Stack<>();
        dfs(root);                                      // Reach the leftmost node to show the minimum
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode value = stk.pop();                     // Pop the top of the stack
        dfs(value.right);                                   // Check to the right subtree for the minimum element node
        return value.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(!stk.empty()){                                       // Check if the stack is empty or not
            return true;
        }
        return false;
    }
    private void dfs(TreeNode root){
        while(root != null){                                // Get the leftmost node for min
            stk.push(root);
            root = root.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */