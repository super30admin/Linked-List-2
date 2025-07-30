// Time Complexity : O(1) amortized for next and O(1) for hasnext
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : use controlled recursion to pause tree traversal unitl we have next node to be returned when next
/// method is called. Resume recursion again when we pop from stack
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
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        this.st = new Stack<>();
        dfs(root);
    }
    private void dfs(TreeNode root)
    {
        while(root!=null){
            st.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        if(!hasNext()){
            return -1;
        }
        TreeNode curr = st.pop();
        dfs(curr.right);
        return curr.val;
    }
    
    public boolean hasNext() {
        return st.size()>0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */