// Time Complexity : O(1) for next() and hasnext()
// Space Complexity : O(h) h is height of tree(logn) which is stored in stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.*;

class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        dfs(root);
    }

    private void dfs(TreeNode root){
        while(root!=null){
            st.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode curr = st.pop();
        int temp = curr.val;
        dfs(curr.right);
        return temp;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }
}

class TreeNode {
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