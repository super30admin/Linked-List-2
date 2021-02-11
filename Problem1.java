// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :No
// Any problem you faced while coding this :Yes
//I tried implement it by adding the binary search tree elements inorder traversal to a linked list . I am not sure If I need to implemetn the linked list
//from scratch for placing  the elements in such a way that hasnext and next works.


// Your code here along with comments explaining your approach
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
    List<TreeNode> treelist= new LinkedList<>();
    TreeNode head;
    public BSTIterator(TreeNode root) {
        recurIterator(root);
        
    }
    public void recurIterator(TreeNode root){
        if(root==null)
            return;
        if(root.left!=null)
            recurIterator(root.left);
        treelist.add(root.left);
        treelist.add(root);
        if(root.right!=null)
        recurIterator(root.right);
        treelist.add(root.right);
        head= treelist.get(0);
        }
    
    public int next() {
        int n=0;
        if(head.next!=null){
             n=head.val;
            head=head.next;
        }        
            return n;
    }
    
    public boolean hasNext() {
        if(head.next==null)
            return false;
        return true;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */