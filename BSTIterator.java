// Time Complexity : O(n), for hasNext and next functions its O(1)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Create a stack and push left of nodes to it until null is reached
//Now in next pop from stack and explore the left of right subtree
//In hasNext function check whether the stack is empty or not.

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
        st = new Stack<>();
        explore(root);
    }
    public void explore(TreeNode node){
        while(node != null){
            st.push(node);
            node = node.left;
        }
    }
    public int next() {
        TreeNode node = st.pop();
        explore(node.right);
            
        return node.val;
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