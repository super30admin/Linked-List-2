// Time Complexity : O(1) amortized per call to next() or hasNext()
//                   Each node is pushed and popped at most once.
// Space Complexity : O(h), where h = height of the BST (stack holds one root-to-leaf path).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//
// Approach (Lazy Evaluation with Stack):
// - Maintain a stack of nodes representing the path to the "next smallest" node.
// - In the constructor, call dfs(root) to push all left descendants of root (so the leftmost is on top).
// - next(): Pop the top (current smallest). If it has a right child, push that right node and all its left descendants.
// - hasNext(): Check if stack is non-empty.
// - This avoids precomputing the entire in-order list, achieving O(h) space.

import java.util.*;

class BSTIterator {
    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        this.st = new Stack<>();
        dfs(root);  // push initial left path
    }

    // Helper: push all left descendants of this node
    private void dfs(TreeNode root) {
        while (root != null) {
            st.push(root);
            root = root.left;
        }
    }

    // Return next smallest element
    public int next() {
        TreeNode temp = st.pop();
        if (temp.right != null) {
            dfs(temp.right); // push left path of right subtree
        }
        return temp.val;
    }

    // Is there a next element?
    public boolean hasNext() {
        return !st.isEmpty();
    }

    // --- Main method for testing ---
    public static void main(String[] args) {
        /*
           Inorder traversal: [3, 7, 9, 15, 20]
        */
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator it = new BSTIterator(root);

        System.out.println("BST in-order iteration:");
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        // Output: 3 7 9 15 20
    }
}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}