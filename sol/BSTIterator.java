package sol;







import java.util.*;

public class BSTIterator {
	
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
	
	 Stack<TreeNode> st= new Stack<>();
	    

	    public BSTIterator(TreeNode root) {
	    
	        TreeNode curr= root;
	        
	        while(curr!=null){
	            
	            st.push(curr);
	            curr=curr.left;
	        }
	        
	    }
	    
	    public int next() {
	       TreeNode curr=st.pop();
	        
	        if(curr.right!=null){
	        TreeNode p=curr.right;    
	            st.push(p);
	            while(p.left!=null){
	                st.push(p.left);
	                p=p.left;
	            }
	            
	        }
	        
	        return curr.val;
	    }
	    
	    public boolean hasNext() {
	     
	        if(!st.isEmpty()) return true;
	        else return false;
	    }
	
	
}
