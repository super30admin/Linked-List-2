//time n
//space n

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

    ArrayList<TreeNode> list;
    int index = 0;

    public BSTIterator(TreeNode root)
    {
        list = new ArrayList<>();
        inorder(root);
    }

    public int next()
    {
        return list.get(index++).val;
    }

    public boolean hasNext()
    {
        return (index<list.size());
    }

    private void inorder(TreeNode root)
    {
        if(root==null) return;

        inorder(root.left);
        list.add(root);
        inorder(root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
