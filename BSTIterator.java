// Time Complexity : O(1)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes

import java.util.Stack;

class BSTIterator {

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

    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        //push all nodes on left onto stack
        dfs(root);
    }

    public int next() { // O(h)
        TreeNode node = st.pop();
        dfs(node.right);
        return node.val;
    }

    public boolean hasNext() { // O(1)
        return !st.isEmpty();
    }

    private void dfs(TreeNode root){
        while(root != null){
            st.push(root);
            root = root.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */