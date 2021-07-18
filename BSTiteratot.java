// Time Complexity : O(1) [for next(), hasNext(), because we are using contructor to push left elements to stack] 
// Space Complexity : O(h)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


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

    Stack<TreeNode> stack;
    
    //constructor to add the all the left nodes to stack till we reach NULL and have the smalledst node on top of the stack
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        controlledDFS(root);
    }
    
    //function to add left subtree to stack to make sure the smallest element is on the top of the stack
    private void controlledDFS(TreeNode root){
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode curr = stack.pop();
        //check if current node has right subtree
        if(curr.right != null){
            controlledDFS(curr.right);
        }
            
        return curr.val;
    }
    
    public boolean hasNext() {
        //if stack is empty, then FALSE
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */