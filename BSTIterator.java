// Time Complexity : O(n)
//T.C of next() and hasNext() : O(1)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Use DFS to push elements from root to left last into stack so that the top is minimum.
//next() will pop from top and calls dfs of right elements
//hasNext() will check if stack is empty or not
import java.util.Stack;
class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack();
        TreeNode node = root;
        dfs(node);
    }

    public int next() {
        TreeNode node = st.pop();
        dfs(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

    private void dfs(TreeNode node){
        while(node != null) {
            st.push(node);
            node = node.left;
        }

    }
}

//Definition for a binary tree node.
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

//
//  Your BSTIterator object will be instantiated and called as such:
//  BSTIterator obj = new BSTIterator(root);
//  int param_1 = obj.next();
//  boolean param_2 = obj.hasNext();
//