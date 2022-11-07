
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


public class BSTIterator {
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


        private Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack =  new Stack<>();
            itr(root);

        }

        private void itr(TreeNode node){
            while(node!=null){
                stack.push(node);
                node = node.left;
            }
        }

        public int next() {
            TreeNode node = stack.pop();
            itr(node.right);
            return node.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */