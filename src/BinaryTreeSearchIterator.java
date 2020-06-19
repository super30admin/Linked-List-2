// Time Complexity : O(h)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/**https://leetcode.com/problems/binary-search-tree-iterator/
 * 
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
	TreeNode prev;
	boolean hasNext;

	public BSTIterator(TreeNode root) {
		st = new Stack<>();

		if(root != null){
			st.push(root);  
		}
	}

	/** @return the next smallest number */
	public int next() {
		int res = -1;

		if(prev != null) {
			res = prev.val;
			if(prev.right != null){
				st.push(prev.right);
				prev = null;
			} else {
				if(!st.isEmpty())   
					prev = st.pop();
				else
					prev = null;
			}
			return res;
		}

		TreeNode root = null;

		if(!st.isEmpty()) {

			root = st.pop();

			while(root != null) {
				st.push(root);
				root = root.left;
			}

			TreeNode curr = st.pop();
			res = curr.val;

			if(curr.right != null) {
				st.push(curr.right);
			}else {
				if(!st.isEmpty())
					prev = st.pop();
			}
		}
		return res;
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		if(st.isEmpty() && prev == null)
			return false;

		return true;
	}
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */