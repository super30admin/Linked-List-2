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
//TC : O(1) SC : O(H)
class BSTIterator {
    Stack<TreeNode> s = new Stack<>();
    public BSTIterator(TreeNode root) {
        dfs(root);
    }

    private void dfs(TreeNode root)
    {
        if(root==null) return;

        while(root!=null)
        {
            s.add(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode n = s.pop();
        dfs(n.right);
        return n.val;
    }

    public boolean hasNext() {
        return !s.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */