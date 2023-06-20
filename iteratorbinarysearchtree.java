// Time Complexity : O(1)
// Space Complexity : O(h) height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Understanding controlled recurssion


// Your code here along with comments explaining your approach:
// Iterators should handle dynamicity as mush as possible. So we are using controlled recurssion.
// To do it we are bringing the stack up the hood.
// we are pushing the root.next element into the stack till it is not null.
// then when next is called we can pop the top element of the stack and call element.right on the popped element
// for hasNext() function we can check if the stack is empty or not .. if it is not empty we can return true



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
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        this.st=new Stack<>();
        inorder(root);
    }
    private void inorder(TreeNode root){
        while(root!=null)
        {
            st.push(root);
            root=root.left;
        }
    }
    
    public int next() {
        TreeNode popped = st.pop();
        inorder(popped.right);
        return popped.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */