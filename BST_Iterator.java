import java.util.Stack;

/**
 * 
 */

/**
 * @author aupadhye
 *
 */
//Time complexity is O(1) for all operations and O(h) is the space complexity.Since the stack can retain h elements in worst case 
   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
 
public class BST_Iterator {
	Stack<TreeNode> stack;
 
	public BST_Iterator(TreeNode root) {// Initialize constructor for the iterator and push all the 
		//smallest elements in the stack since it is a forward iterator.
		stack = new Stack<TreeNode>();
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}
 
	public boolean hasNext() {
		return !stack.isEmpty();// Return if stack is empty or not 
	}
 
	public int next() {
		TreeNode node = stack.pop();// If next is called pop an element and return the result while push all 
		//the right elements of the poped element right subtree
		int result = node.val;
		if (node.right != null) {
			node = node.right;
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		
		TreeNode tree = new TreeNode(5);
		tree.left = new  TreeNode(3);
		tree.right = new TreeNode(7);
		tree.left.left = new TreeNode(2);
		tree.left.right = new TreeNode(4);
		tree.right.left = new TreeNode(6);
		tree.right.right = new TreeNode(8);
		
		BST_Iterator it = new BST_Iterator(tree);
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.hasNext());
		
		
		
	}
}
