// Time Complexity : hasNext - O(1)
// next - O(1) amortized
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes. Could not figure out the code. Had to refer lecture




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
    //Stack to keep track of which nodes are pending to be processed
    Stack<TreeNode> stk;
    public BSTIterator(TreeNode root) {
        stk = new Stack<>();
        //Getting the leftmost element and storing other elements which came before the leftmost in the stack
        while(root!=null){
            stk.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        //get the element on top of the stack and process it. Run DFS on the right of the current element 
        TreeNode root = stk.pop();
        TreeNode head = root.right;

        while(head!=null){
            stk.push(head);
            head = head.left;
        }

        return root.val;
    }
    
    public boolean hasNext() {
        //Check if stack is empty or not
       return !stk.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */