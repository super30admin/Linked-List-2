import java.util.Stack;

/**
## Problem1 (https://leetcode.com/problems/binary-search-tree-iterator/)
 
Time Complexity :   O (N) 
Space Complexity :  O (1) 
Did this code successfully run on Leetcode :    Yes (173. Binary Search Tree Iterator)
Any problem you faced while coding this :       No
 */

// Input:    ["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
//           [[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
// Output:   [null, 3, 7, true, 9, true, 15, true, 20, false]

class BSTIterator {
    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        helper(root);
    }
    public void helper(TreeNode root) {
        while(root!=null){
            st.push(root);
            root = root.left;
        }
    }
    
    public int next() {      // O(h)  -- worst case. , O(1) - average case
        TreeNode node = st.pop();
        helper(node.right);
        return node.val;
    }
    
    public boolean hasNext() {
        if(!st.isEmpty()){
            return true;
        }
        return false;
    }
}