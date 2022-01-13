package linkedList2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySearchTreeIterator {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	//Time Complexity : O(h), in the worst case, where h is the height of tree
	//                : o(1) for average case
	//Space Complexity : O(1)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	Stack<TreeNode> stack;
    public BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<>();
        dfs(root);
    }
    
    public int next() {
        TreeNode node = stack.pop();
        dfs(node.right);
        return node.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    private void dfs(TreeNode root) {
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
    }
	 
	//Time Complexity : O(n), where n is the height of tree
	//Space Complexity : O(1)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	//This is not the best solution as it does not address the dynamic problems
	List<Integer> list;
    TreeNode root;
    int i;
    public BinarySearchTreeIterator(TreeNode root) {
        list = new ArrayList<>();
        inorder(root);
        i = 0;
    }
    
    public int next1() {
        return list.get(i++);
    }
    
    public boolean hasNext1() {
        return i < list.size();
    }
    
    private void inorder(TreeNode root) {
        if(root == null)
            return;
        
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}
