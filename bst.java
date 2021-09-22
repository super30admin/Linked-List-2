
// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

import java.util.*;
// Your code here along with comments explaining your approach
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

  public class bst {
       Stack<TreeNode>st;
       public bst(TreeNode root) {
           st=new Stack<>();
           dfs(root);
       }
       
       public int next() {
           TreeNode result=st.pop();
           dfs(result.right);
           return result.val;
       }
       
       public boolean hasNext() {
           return !st.isEmpty();
       }
       private void dfs(TreeNode root){
           while(root!=null){
               st.push(root);
               root=root.left;
           }
       }
   }
