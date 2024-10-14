// Time Complexity :  0(1)
// Space Complexity : 0(n)
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
class BSTIterator {
    //aesha
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        this.st = new Stack<>();
        init(root);
    }
    
    public void init(TreeNode root)
    {
        while(root!=null)
        {
            st.push(root);
            root = root.left;
        }
    }
    public int next() {
        TreeNode temp = st.pop();
        init(temp.right);
        return temp.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */