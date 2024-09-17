// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :yes
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
    List<Integer> list = new ArrayList();
    public BSTIterator(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        while(root != null || !stack.isEmpty() ){
            if(root != null){
                stack.push(root);
                root=root.left;
            }else{
                TreeNode node =stack.pop();
                list.add(node.val);
                root=node.right;
            }
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        return list.remove(0);
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !list.isEmpty();
    }
}
