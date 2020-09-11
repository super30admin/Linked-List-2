// TC: O(N) since we traversing every node in tree.
// SC: O(N) since we are storing every node in List.

// We doing inorder traversal and storing it in a list because we know that the inorder traversal will give us values stored in ascending order. These values are stored in list in ascending order.
// next() - We can retrieve the first element of list since it gives us the minimum element. Once we have the first element, we will delete that number from list since 
// the question does not ask for keeping track of previous elements. For hasNext() - we can just check if the list size is empty or not.
import java.util.*;

public class BSTIterator {

	List<Integer> res;
	public BSTIterator(TreeNode root) {
		res = new ArrayList();
		inorder(root);
	}
	
	public void inorder(TreeNode root){
			
		Stack<TreeNode> st = new Stack();
		
		while(root!=null || !st.isEmpty()) {
			
			while(root!=null) {
				st.push(root);
				root = root.left;
			}
			
			root = st.pop();
			int val = root.val;
			res.add(val);
			root = root.right;
		}
	}
	
	public int next() {
		
		int nextValue = res.get(0);
		res.remove(0);
		return nextValue;
	}
	
	public boolean hasNext() {
		
		return res.size()!=0;
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(7);
		root.left = new TreeNode(3);
		root.right = new TreeNode(15);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(20);
		
		BSTIterator bstit = new BSTIterator(root);
		
		System.out.println(bstit.next());
		System.out.println(bstit.next());
		System.out.println(bstit.hasNext());
		System.out.println(bstit.next());
		System.out.println(bstit.hasNext());
		System.out.println(bstit.next());

		System.out.println(bstit.hasNext());
		System.out.println(bstit.next());

		System.out.println(bstit.hasNext());

		
	}
}
