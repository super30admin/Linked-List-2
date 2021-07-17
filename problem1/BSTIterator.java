// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

import java.util.ArrayList;
import java.util.List;

public class BSTIterator {
	TreeNode root;
	List<Integer> inorder;
	int index;

	private void getInorder(TreeNode root) {
		if (root == null) {
			return;
		}

		getInorder(root.left);
		inorder.add(root.val);
		getInorder(root.right);
	}

	public BSTIterator(TreeNode root) {
		this.root = root;
		this.inorder = new ArrayList<Integer>();

		getInorder(root);
		this.index = 0;
	}

	public int next() {
		return this.inorder.get(this.index++);
	}

	public boolean hasNext() {
		return this.index < this.inorder.size();
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(7);
		root.left = new TreeNode(3);
		root.right = new TreeNode(15);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(20);
		BSTIterator obj = new BSTIterator(root);
		System.out.println("Next Element: " + obj.next());
		System.out.println("Has Next? " + (obj.hasNext() ? "Yes" : "No"));
	}

}
