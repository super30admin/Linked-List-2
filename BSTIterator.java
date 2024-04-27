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
//Time Complexity : Average Case Time Complexity - O(1)
//Space Complexity : O(h), h is height of binary search tree
//Did this code run successfully on Leetcode : Yes
 class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        this.st = new Stack<>();
        init(root);
    }
    //controlled Recursion
    //Until we reach leaf node, all the left children are pushed into the stack
    private void init(TreeNode root) {
        while(root != null) {
            st.push(root);
            root = root.left;
        }
        
    }
    //returns top value in the stack and before returning, we push the right child into the stack if it has any
    public int next() {
        TreeNode next = st.pop();
        init(next.right);
        return next.val;
    }
    //returns true if stack is not empty
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