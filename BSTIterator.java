// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

import java.util.Stack;

public class BSTIterator {
	 Stack<TreeNode> stack;
	    public BSTIterator(TreeNode root) {
	        stack=new Stack<>();
	        helper(root);
	    }
	    
	    public int next() {
	        TreeNode node=stack.pop();
	        helper(node.right);
	        return node.val;
	    }
	    
	    public boolean hasNext() {
	        return !stack.isEmpty();
	    }
	    
	    public void helper(TreeNode root){
	        if(root==null){
	            return;
	        }
	        
	        stack.push(root);
	        helper(root.left);
	    }
	    
	    public class TreeNode {
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
}
