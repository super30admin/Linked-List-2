// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Iterator should have access to only the next element of the tree and not to all the nodes incase of inorder traveral. 
import java.util.Stack;

public class BinarySearchTreeIterator {

	public class TreeNode {
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

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	Stack<TreeNode> st;

	public void BSTIterator(TreeNode root) {

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