// Time Complexity :O(depth)
// Space Complexity :O(depth)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


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
    Stack<TreeNode> st= new Stack<>();//Stack to maintain all the left most element
    
    public BSTIterator(TreeNode root) {
            dfs(root);
        }
    
    public void dfs(TreeNode root)//dfs to traverse till left and check right only when next() function is called.
    {
           while(root!=null){
                st.push(root);
                root=root.left;
            }       
    }
    
    public int next() {
        if(hasNext())
        {
            TreeNode temp=st.pop();
            if(temp.right!=null)
                dfs(temp.right);
            return temp.val;
        }
        return -1;
    }
    
    public boolean hasNext() {
        if(!st.isEmpty())
            return true;
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */