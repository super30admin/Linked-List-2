// Time Complexity : O(H) //for next it is height of tree
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
 * 1. Create a stack and fill left traversal in the stack.
 * 2. when ever next called pop an element and call dfs for right side tree.
 * 3. has next will check is tsack is empty or not.
 */
import java.util.Stack;
public class BSTIterator {

	Stack<TreeNode> stack;

	public BSTIterator(TreeNode root) {
		stack = new Stack<>();
		dfs(root);
	}

	public int next() {
		TreeNode root = stack.pop();
		dfs(root.right);
		return root.val;
	}

	public boolean hasNext() {
		return !stack.isEmpty();
	}

	private void dfs(TreeNode root) {

		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}
}

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
