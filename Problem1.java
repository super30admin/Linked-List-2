public class Problem1 {
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


        Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            dfs(root);
        }
        //t.c ->O(h)
        //s.c -> O(h)
        public int next() {
            TreeNode pop = stack.pop();
            //move only move ahead as much necessary
            dfs(pop.right);
            return pop.val;
        }
        //t.c ->O(1)
        //s.c ->O(1)
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        private void dfs(TreeNode root){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
        }
    }
}
