    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/binary-search-tree-iterator/
    Time Complexity for operators : o(1) .. will return the element (1) time complexity for returning element hasnext().
    Extra Space Complexity for operators : o(h) ... we r storing element = height of tree in a stack.
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 

        # Optimized approach -
                              
            # 1st one - 
                    A. One constructor Initialized, at that time stack gets intialized and dfs gets called
                       and we will initially traverse till the end(left).
                    B. For hasNext() just check whether stack is empty or not.
                    C. For next(), pop from the stack and check whether it has right or not.
                    D. If it has right(), then go to DFS finction and pass the right to it.
                    E. At the end, return value of popped element.
       */


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class BSTIterator {

    private Stack<TreeNode> stack;
    
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        dfs(root);
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode retVal = stack.pop();
        if(retVal.right!=null){
            dfs(retVal.right);
        }
        
        return retVal.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    private void dfs(TreeNode root){
        while(root!=null){
            stack.push(root);
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