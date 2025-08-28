import java.util.*;

// Definition for a binary tree node
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


// Time Complexity : O(n) to build list during initialization, 
//                   O(1) for next() and hasNext()
// Space Complexity : O(n) to store entire inorder traversal in a list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//
// Approach : 
// Do a full inorder traversal in the constructor and store values in a list.
// Use index pointer to return values sequentially in sorted order.
// Simple to implement, but not memory efficient.

class BSTIterator {
    ArrayList<Integer> list;
    int index;

    public BSTIterator(TreeNode root) {
        this.list = new ArrayList<>();
        this.index = 0;
        helper(root);
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        list.add(root.val);
        helper(root.right);
    }

    public int next() {
        return list.get(index++);
    }

    public boolean hasNext() {
        return index < list.size();
    }
}


// Time Complexity : O(h) for next() in worst case (h = height of tree), 
//                   O(1) for hasNext()
// Space Complexity : O(h) for stack (not O(n)), since we only store path of left nodes
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//
// Approach : 
// Instead of storing all nodes upfront, we use a stack to simulate inorder traversal lazily.
// Push all left children initially. For next(), pop from stack, 
// and push left path of its right child. This ensures values come in sorted order.
//
//Better for interviews because
// - Memory efficient (does not store entire tree upfront, only O(h) space).
// - Matches the design of a true iterator: "generate values on demand".
// - Interviewers prefer this because it avoids brute-force full traversal/ shouldnt load everything inside memory.

class BSTIterator2 {
    Stack<TreeNode> st;

    public BSTIterator2(TreeNode root) {
        this.st = new Stack<>();
        helper(root);
    }

    private void helper(TreeNode root) {
        while (root != null) {
            st.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode temp = st.pop();
        helper(temp.right); // push left chain of right subtree
        return temp.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }
}
