// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
// to allow dynamicity in a datastructure, iterators are used
// create a new stack of treenodes and and call inorder on root node, where only left nodes are
// processed, only when an element is popped are its right nodes processed and added to stack
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
    // declare a stack
    Stack<TreeNode> st; 
    public BSTIterator(TreeNode root) {
        this.st = new Stack<>();
        inorder(root);
    }

    public void inorder(TreeNode root){
        while (root!=null){
            this.st.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode v = this.st.pop();
        inorder(v.right);
        return v.val;
    }
    
    public boolean hasNext() {
        return !this.st.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */