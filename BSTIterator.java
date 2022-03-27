/*

// Time Complexity : to addinng the elements O(n), for int next O(1), for has next O(1)
// Space Complexity : O(n) if we count stack space as space.
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach 


*/


import java.util.*;

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
 
public class BSTIterator {
    // created linkedlist which work as stack 
    LinkedList<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new LinkedList<>();
        addElements(root);
    }
    
    private void addElements(TreeNode root) {
        // adding the elements in the linkedlist.

        while(root != null) {
            
            st.addFirst(root);
            root = root.left;
        }
    }
    
    public int next() {
      //  removing the element and adding eleements on the right side.

         TreeNode temp = this.st.removeFirst();
        
        addElements(temp.right);
       
       
        // returning the value
        return temp.val;
        
    }
    
    public boolean hasNext() {
        // checking if list is empty or not

        return this.st.size() != 0;
    }
}

