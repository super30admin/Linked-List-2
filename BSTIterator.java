// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
Have a stack where we iteratively push the root and all its left children such that through LIFO policy,
we obtain the inorder. However, we need to make sure the right children also need to be pushed as part of
the traversal. So we push them while we are popping out the left children. This way, lazy evaluation is
maintained.
 */
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
        this.st = new Stack<>();
        helper(root);
    }

    public int next() {
        TreeNode temp = st.pop();
        helper(temp.right);
        return temp.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

    private void helper(TreeNode root) {
        while(root != null) {
            st.push(root);
            root = root.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */