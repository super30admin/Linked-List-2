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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// BinarySearchTreeIterator bSTIterator = new BinarySearchTreeIterator({7, 3,
		// 15, null, null, 9, 20});
//		bSTIterator.next();    // return 3
//		bSTIterator.next();    // return 7
//		bSTIterator.hasNext(); // return True
//		bSTIterator.next();    // return 9
//		bSTIterator.hasNext(); // return True
//		bSTIterator.next();    // return 15
//		bSTIterator.hasNext(); // return True
//		bSTIterator.next();    // return 20
//		bSTIterator.hasNext(); // return False

	}

}
