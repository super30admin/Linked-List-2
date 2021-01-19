import java.util.*;

//Time Complexity : Avg o(1) worst - o(h) height of the tree
//Space Complexity : o(h)
//Did this code successfully run on Leetcode :Yes
public class BSTIterator {
	
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
	
	Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        dfs(root);
    }
    
    public int next() {
        TreeNode result = st.pop();
        //once we pop the element call right iterative call on node
        dfs(result.right);
        return result.val;
    }
    
    public boolean hasNext() {
    	//should have elements till stack is empty
        return !st.isEmpty();
    }
    
    private void dfs(TreeNode root) {
    	// iterator so have to vary about only next element
        while(root != null) {
            st.push(root);
            //push all left nodes to stack and stop
            root = root.left;
        }
    }

}
