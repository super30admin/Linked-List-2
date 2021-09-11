// Time Complexity : O(h) worst case hiegth of tree 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : no
// Any problem you faced while coding this : getting error :Error - Found cycle in the ListNode


// Your code here along with comments explaining your approach
1. in constructor fill a stack with all left leaves
2. on next pop the top value and return also fill the stack with all the leaves under that  leave
3. on hasnext just check if stack is empty or not.

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

    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
       stack = new Stack(); 
        dfs(root);
    }
    
    public int next() {
        if(!stack.isEmpty())
        {
        TreeNode ele =  stack.pop();
            dfs(ele.right);
        return ele.val;
        }
       else return -1;
    }
    
    public boolean hasNext() {
       return !stack.isEmpty();
    }
    
    private void dfs(TreeNode root)
    {
        while(root != null)
        {   
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