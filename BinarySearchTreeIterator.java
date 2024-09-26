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
    Stack<TreeNode> controlledrecursion;
    public BSTIterator(TreeNode root) {
        controlledrecursion=new Stack<>();
        dfs(root);
    }

    public int next() {
        TreeNode result=controlledrecursion.pop();
        dfs(result.right);
        return result.val;
    }

    public boolean hasNext() {
        return !controlledrecursion.isEmpty();
    }
    private void dfs(TreeNode root)
    {
        while(root!=null)
        {
            controlledrecursion.push(root);
            root=root.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */