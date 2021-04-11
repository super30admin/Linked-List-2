/*
Run time complexity - O(1) - it is the amortized constant run time as the space push happens not very often. 
Space complexity - O(N) where N is the number of elements in the input.
*/

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

    Stack<TreeNode> s1;
    public BSTIterator(TreeNode root) {
         s1=new Stack<>();
         inorder_traversal(root);
    }
    
    public void inorder_traversal(TreeNode root)
    {
        while(root!=null)
        {
            s1.push(root);
            root=root.left;
        }
    }
    
    public int next() {
        TreeNode nextnode=s1.pop();
        inorder_traversal(nextnode.right);
        return nextnode.val;
    }
    
    public boolean hasNext() {
        return s1.size()>0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
