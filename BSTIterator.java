import java.util.ArrayList;
import java.util.List;

//Time Complexity : O(N) for constructor if considered, else O(1)
//Space Complexity : O(N) for inorder traversal recursion stack.
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

/**
 * Store all the nodes of BST in the list. maintain
 * an index pointer. Store the nodes using inorder
 * traversal. Then whenever next is called, return that
 * particular index and increment index. Also, to check
 * if the list index is not out of bound, check if index
 * is less than the size of the list.
 *
 */
class BSTIterator {
	int index;
	List<Integer> nodes;

	public BSTIterator(TreeNode root) {
		nodes = new ArrayList<>();
		index = 0;
		this.inorder(root);
	}

	public void inorder(TreeNode root) {
		if (root == null)
			return;
		inorder(root.left);
		nodes.add(root.val);

		inorder(root.right);
	}

	public int next() {
		return nodes.get(index++);
	}

	public boolean hasNext() {
		return index < nodes.size();
	}
}
