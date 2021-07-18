// Time Complexity : O(1)
// Space Complexity : O(n) {not efficient approach bcz we should store all the node of tree in arrayList}
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


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
    
    //storing all the tree nodes in array of inorder traversal list
    ArrayList<Integer> list;
    int curr;
    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        inorder(root);
    }
    
    private void inorder(TreeNode root){
        //base
        if(root == null)
            return;
        //left
        inorder(root.left);
        //root
        list.add(root.val);
        //right
        inorder(root.right);
    }
    
    public int next() {
        //get the curr pointer element
        int small = list.get(curr);
        //increment the curr pointer
        curr++;
        //return smallest in BST
        return small;
    }
    
    public boolean hasNext() {
        //if curr pointer is at end of list, return false
        if(curr == list.size())
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