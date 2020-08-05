// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


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
    
    List<Integer> arr;
    int ptr;
    public BSTIterator(TreeNode root) {
        arr = new ArrayList<>();
        ptr = 0;
        inorder(root);
    }
    
    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        arr.add(root.val);
        inorder(root.right);
    }
    
    /** @return the next smallest number */
    public int next() {
    return arr.get(ptr++); //return next value    
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return ptr != arr.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */