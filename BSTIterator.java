// Time Complexity : O(h) height of the tree  - worst case 
//                  : O(1)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :



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
      st = new Stack<>();
      dfs(root);
    }
    
    public int next() {
      //pop the top of stack 
      TreeNode node = st.pop();
      dfs(node.right);
      return node.val;
      
    }
    //if stack is not empty then next element exist
    public boolean hasNext() {
      return !st.isEmpty();
        
    }
  private void dfs(TreeNode root) {
    //push left till we reach leaf
    while(root!=null) {
      st.push(root);
      root = root.left;
    }
  }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */