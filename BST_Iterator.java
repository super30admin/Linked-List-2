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
    //Time O(H)
    //Space O(H)
    Stack<TreeNode> stack;
    TreeNode Node;
    public BSTIterator(TreeNode root) {
        Node = root;
        stack = new Stack<>();
        dfs(Node);
    }
    public void dfs(TreeNode root)
    {
        while(root != null)
        {
            stack.push(root);
            root = root.left;
        }
    }
    public int next() {
        TreeNode pop = stack.pop();
        int val = pop.val;
        dfs(pop.right);
        return val;
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