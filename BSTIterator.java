// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.util.Stack;
import com.util.customlist.TreeNode;


public class BSTIterator {
	Stack<TreeNode> st;

	public BSTIterator(TreeNode root) {
		st = new Stack<>();
		dfs(root);
	}

	public int next() {
		TreeNode result = st.pop();
		dfs(result.right);
		return result.val;
	}

	public boolean hasNext() {
		return !st.isEmpty();
	}

	private void dfs(TreeNode root) {
		while (root != null) {
			st.push(root);
			root = root.left;
		}
	}
	
}
