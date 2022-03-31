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

    ArrayList<Integer> list;
    
    public BSTIterator(TreeNode root) {
        this.list = new ArrayList<>();
        inorder(root);
    }
    
    public void inorder(TreeNode node){
       
        if(node==null){
            return;
        }
        
        inorder(node.left);
        this.list.add(node.val);
        inorder(node.right);
        
        return;
    }
    
    public int next() {
        int res = list.remove(0);
        return res;
    }
    
    public boolean hasNext() {
        return list.size() != 0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
