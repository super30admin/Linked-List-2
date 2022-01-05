// Time Complexity :O(1) amortised
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * We use our own stack to control recursion and keep a pointer to element supposed to be return by next method
 * So in constructor we put all elements to root.left including root in stack
 * Now for each next call, we have element at top of stack pointing which should be return
 * For each next call, after popping from stack, we check if there are any nodes to its right and ut them in stack as well
 * hasNext will simply check if stack is empty or not. If stack is empty we will return false or else return true
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
    Stack<TreeNode> s;
    
    private void dfs(TreeNode root){
        //base case
        if(root == null)return;
        
        //logic
        s.push(root);
        dfs(root.left);
    }
    
    public BSTIterator(TreeNode root) {
        s = new Stack<>();
        dfs(root);
    }
    
    public int next() {
        TreeNode cur = s.pop();
        dfs(cur.right);
        return cur.val;
    }
    
    public boolean hasNext() {
        if(s.isEmpty())return false;
        return true;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */