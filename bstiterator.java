// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
// approach: we take a stack. we push all the root.left values into the stack until root.left value is null. whenever the hasnext function is 
// called, we check if the stack is empty or not, if empty return false, else return true. when next function is called, we pop the node from the 
// stack and check if the popped node has any right node,if it has a right node, push all the left elements into the stack. 

// Your code here along with comments explaining your approach
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
    Stack<TreeNode> stack =new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        while(root!=null)
        {
            stack.push(root);
            root=root.left;
        }
    }
    
    public int next() {
        TreeNode res=stack.pop();
        TreeNode cur=res.right;
        while(cur!=null)
        {
            stack.push(cur);
            cur=cur.left;
        }
        return res.val;
    }
    
    public boolean hasNext() {
        return (!stack.isEmpty());
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */