// TC - O(1)
// SC - O(n)

import java.util.Stack;

public class BST_Iterator {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static class BSTIterator {
        Stack<TreeNode> st;

        public BSTIterator(TreeNode root) {
            st = new Stack<>();
            helper(root);
        }

        private void helper(TreeNode root) {
            while ( root != null) {
                st.push(root);
                root = root.left;
            }
        }

        // O(h) where h is height for worst case, Average case it will be O(1)
        public int next() {
            TreeNode node = st.pop();
            helper(node.right);
            return node.val;
        }

        // O(1)
        public boolean hasNext() {
            return !st.isEmpty();
        }
    }

}
