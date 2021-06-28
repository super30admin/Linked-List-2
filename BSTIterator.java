package LinkedList2;

import java.util.Stack;

/* Time complexity : o(h) - L is length untill nth node
 * Space complexity : o(1)
Did this code run successfully in leetcode : yes
problems faces : no
*/

class BSTIterator {
    
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val){
			this.val = val;
		}
		TreeNode(int val, TreeNode left, TreeNode right){
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	 Stack<TreeNode> s;
	    public BSTIterator(TreeNode root) {
	        s = new Stack<>();
	        dfs(root);
	    }
	    
	    public int next(){
	        TreeNode node = s.pop();
	        dfs(node.right);
	        return node.val;
	        
	    }
	    
	    public boolean hasNext() {
	       return !s.isEmpty();
	    }

	    private void dfs(TreeNode root){
	        while(root!=null){
	            s.push(root);
	            root = root.left;            
	        }
	    }
	}
