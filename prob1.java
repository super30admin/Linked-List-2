// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes


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
    List<Integer> list;
    int next = 0; //initial index;

    public BSTIterator(TreeNode root) {
        this.list = new ArrayList<>();
        
        dfs(root); //collect all the values to the given list using in-order traversal of tree
    }
    
    public int next() {
        return  list.get(next++);
    }
    
    public boolean hasNext() {
        return list.size() > next;
    }
   
    private void dfs(TreeNode root) {
        if(root == null) {
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}
