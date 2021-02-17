/**
Time:O(n) for traversing all the elements
Space:O(d) max depth for stack

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
        //initialise stack
        stack = new Stack<TreeNode>();
        dfs(root);
    }
    
    private void dfs(TreeNode root){
        //recursive
        // if(root == null)
        //     return;
        // stack.push(root);
        // dfs(root.left);

        //iterative
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode node = stack.pop();
        if(node.right != null){
            dfs(node.right);
        }
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