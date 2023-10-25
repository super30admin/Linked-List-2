// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class BSTIterator {
    class BSTIterator {
        Stack<TreeNode> stack;
        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            inorder(root); //traverse all left nodes and store in stack
        }

        private void inorder(TreeNode root){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
        }

        public int next() {
            TreeNode popped = stack.pop();
            inorder(popped.right); //traverse all left nodes of current right node and store in stack
            return popped.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
