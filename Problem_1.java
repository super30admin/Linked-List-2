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
// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// get all the left nodes to the stack in the iterator
// get the top element of the stack when ask for next
// and also traverse the right node when asked for pop
// resturn NOT-isEmpty when ask for hasNext
// Your code here along with comments explaining your approach
class BSTIterator {

    Stack <TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack<>(); // innitialize the stack
        getInOrder(root);   // get all the left  nodes to the stack
    }

    public int next() {
        TreeNode result = st.pop(); // remove the top elemnet
        getInOrder(result.right); // get the right part of the node the stack
        return result.val;
    }

    public boolean hasNext() {
        return !st.isEmpty(); // return NOT-isEmpty while asking for hasNext
    }

    private void getInOrder(TreeNode node){
        while(node != null){
            st.push(node); // push the node and go to the left next node
            node = node.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */