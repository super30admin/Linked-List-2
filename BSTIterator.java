// Time Complexity : hasnext : O(1), next : O(h) in worst case but amortixed is O(1) averagely
// as for n/2 level (leafs) - O(1) , for one level up (n/4) O(1) - 75% of them complete in O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
/* Approach:
We use our own stack as we have to control the recursion.
We go towards the left, when left is done, we process the root, and go towards the right
*/
class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        this.st = new Stack<>();
        helper(root);        
    }
    private void helper(TreeNode root){
        while(root!=null){
            st.push(root);
            root = root.left;   
        }
    }
    
    public int next() { //O(h) ~ O(1)
        TreeNode r = st.pop();
        helper(r.right);
        return r.val;
        
    }
    
    public boolean hasNext() { //O(1)
        return (!st.isEmpty());
    }

}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */