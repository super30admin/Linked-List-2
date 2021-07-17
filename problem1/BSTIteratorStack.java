package problem1;

import java.util.Stack;

public class BSTIteratorStack {
	Stack<TreeNode> stack;
	TreeNode root;

	public void leftMostInorder(TreeNode root) {
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}

	public BSTIteratorStack(TreeNode root) {
		this.root = root;
		stack = new Stack<TreeNode>();

		leftMostInorder(root);
	}

	public int next() {
		TreeNode curr = stack.pop();

		if (curr.right != null) {
			leftMostInorder(curr.right);
		}
		return curr.val;
	}

	public boolean hasNext() {
		return !stack.isEmpty();
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(7);
		root.left = new TreeNode(3);
		root.right = new TreeNode(15);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(20);
		BSTIteratorStack obj = new BSTIteratorStack(root);
		System.out.println("Next Element: " + obj.next());
		System.out.println("Has Next? " + (obj.hasNext() ? "Yes" : "No"));
	}

}
