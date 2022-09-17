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
        helper(root);
    }

    private void helper(TreeNode root){ // O(h)
        while(root!=null){
            stack.push(root);
            helper(root.left);
        }
    }

    public int next() {     // O(height).... on avg O(1) because apprx. 75% of the nodes can be traversed
        TreeNode node = stack.pop();    // in O(1) complexity [50% leaf nodes + 25% level above leaf]
        helper(node.right);
        return node.val;
    }

    public boolean hasNext() {  // O(1)
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */