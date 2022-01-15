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
    // Time Complexity : O(1) average TC
    // Space Complexity : O(h), where h is the height of the tree
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack<TreeNode>();
        while (null != root) {
            st.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode curr = st.pop();
        TreeNode temp = curr.right;
        while (null != temp) {
            st.push(temp);
            temp = temp.left;
        }
        return curr.val;
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