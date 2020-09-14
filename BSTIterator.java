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
    // Time Complexity:     O(n) - Number of nodes
    // Space Complexity:    O(h) - Height of the root node / Depth of the deepest node

    private Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        dfs(root);
    }
    
    /** @return the next smallest number */
    public int next() {

        if(!hasNext())
            return -1;

        TreeNode nxt = stack.pop();
        if(nxt.right != null){
            dfs(nxt.right);
        }
        return nxt.val;
    }
    
    public void dfs(TreeNode node){
        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }
    
    /** @return whether we have a next smallest number */
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