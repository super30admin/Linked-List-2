// Time Complexity : O(1)
// Space Complexity : O(H), H is height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.*;

class TreeNode {

	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

class BST_Iterator {
	Stack<TreeNode> st;

	public BST_Iterator(TreeNode root) {
		st = new Stack<>();
		dfs(root);
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode node = st.pop();
		dfs(node.right);
		return node.val;
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !st.isEmpty();
	}

	public void dfs(TreeNode root) {
		while (root != null) {
			st.push(root);
			root = root.left;
		}
	}
}