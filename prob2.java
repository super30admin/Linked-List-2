// Time Complexity : O(n) = n/2 to get middle, n/2 to reverse half list, n to reorder
// Space Complexity : O (1) no extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : typos

import java.util.*;

public class prob2 {
    public class TreeNode{
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

    public static java.util.Stack<TreeNode> st;
    public static void  BSTIterator(TreeNode root) {
        st = new java.util.Stack<>();
        dfs(root);
    }
    
    public static int next() {
        TreeNode result = st.pop();
        dfs(result.right);
        return result.val;
        
    }
    
    public static boolean hasNext() {
        return !st.isEmpty();
        
    }
    
    public static void dfs(TreeNode root){
        while(root != null){
            st.push(root);
            root = root.left;
        }
    }

    public static void main(String[] args) {
        
    }
    
}
