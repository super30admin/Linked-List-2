package Linked-List-2;

public class problem1 {
 // Time Complexity : avg case - O(1) bith next and hasnext, worst O(h)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
 
    Stack<TreeNode> s;

    public BSTIterator(TreeNode root) {
        s = new Stack<>();
        helper(root);        
    }
    
    public int next() {
        TreeNode popped = s.pop();
        helper(popped.right);
        return popped.val;
    }
    
    public boolean hasNext() {
        return !s.isEmpty();
    }
    
    public void helper(TreeNode root){
        while(root != null){
            s.push(root);
            root = root.left;
        }
    }
}
