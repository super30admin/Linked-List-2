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
    ArrayList<Integer> li;
    int i;
    public BSTIterator(TreeNode root) {
       li = new ArrayList<>();
       inorder(root);
    }
    
    public int next() { // tc - o(1)
        int ele = li.get(i);
        i++;
        return ele;
        
    }
    
    private void inorder(TreeNode root)
    {
        if(root == null) return;
        inorder(root.left);
        li.add(root.val);
        inorder(root.right);
    }
    
    
    public boolean hasNext() { //tc - o(1)
        return i != li.size();
        
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */