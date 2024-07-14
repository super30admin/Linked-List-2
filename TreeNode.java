
// Time Complexity : O(n)
// Space Complexity : O(1)
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
    List<TreeNode> li;
    int idx;
    public BSTIterator(TreeNode root) {
        this.li = new ArrayList<>();
        inorder(root);
    }
    
    private void inorder(TreeNode root){
        if(root==null) return;

        inorder(root.left);
        li.add(root);
        inorder(root.right);
    }

    public int next() {
        int re = li.get(idx).val;
        idx++;
        return re;
    }
    
    public boolean hasNext() {
       if(idx!=li.size())return true;
       return false; 
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */