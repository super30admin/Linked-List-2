// Time Complexity : O(1)), ()average case)
// Space Complexity : O(h),
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No
package linkedList2;
import java.util.*;
  //Definition for a binary tree node.
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        depthFirstSearch(root);
    }
    
    public int next() {
        TreeNode node = st.pop();
        depthFirstSearch(node.right);
        return node.val;
        
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
    
    public void depthFirstSearch(TreeNode root){
        while(root != null){
            st.push(root);
            root = root.left;
        }
    }
}
