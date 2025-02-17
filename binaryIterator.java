// Problem1 (https://leetcode.com/problems/binary-search-tree-iterator/)

// Time Complexity : O(n) 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, Iterator is used for lazy loading. A stack is used to store all the left nodes. In any case if node is removed, right nodes of that
 * particular left node is added to the stack. This way, time is reduced without looking at all nodes at once but will be checked if only
 * necessary at that particular time.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {

    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        TreeNode node = root;
        dfs(node);
    }
    
    public int next() {
        TreeNode node = st.pop();
        dfs(node.right);
        return node.val;
    }
    
    public boolean hasNext() {
        return !(st.isEmpty());
    }
    public void dfs(TreeNode node){
        while(node!=null){
            st.push(node);
            node = node.left;
        }
    }
}