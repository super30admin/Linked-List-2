// Time Complexity : O(1)
// Space Complexity : o(N), recursive stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

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


/*
We will be using over the hood recursion, to control it.In Iterator, the whole array is not stored in the memory
to handle indefinite data. Will perform iterative inorder traversal.

*/
class Problem1 {

    //will create a global stack
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack<>();

        //helper function to make recursive calls
        helper(root);
    }

    private void helper(TreeNode root){
        //will push the root to the stack
        while(root!=null){
            st.push(root);
            root = root.left;
        }


    }


    //O(H) , worst case //O(1) average
    public int next() {
        TreeNode node = st.pop();
        helper(node.right);

        return node.val;
    }

    //O(1)
    public boolean hasNext() {
        if(!st.isEmpty()) return true;

        return false;

    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */