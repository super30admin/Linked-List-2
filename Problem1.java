
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I couldnt solve it using O(h) space
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {
    Stack<Integer> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
              addToStack(root);
    }
    
    private void addToStack(TreeNode root){
        if(root!=null){
            addToStack(root.right);
            stack.push(root.val);
            addToStack(root.left);
        }
    }
    /** @return the next smallest number */
    public int next() {
        return stack.pop();
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */