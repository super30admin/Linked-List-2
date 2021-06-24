package LinkedList2;

import java.util.Stack;

public class question52_BSTIterator {
    /* Created by palak on 6/23/2021 */

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
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

    class BSTIterator {
        /*
            Time Complexity: O(1)
            Space Complexity: O(1)
        */
        Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            dfs(root);
        }

        public int next() {
            TreeNode node = stack.pop();
            dfs(node.right);
            return node.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        private void dfs(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }
    }

    public static void main(String[] args) {

    }
}
