/*
Time Complexity: O(h) for next() and hasNext() where h is the height of the tree.
Space Complexity: O(h) for the stack used to store the nodes.
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
Intuition: The idea is to use a stack to simulate the in-order traversal of the BST. 
We push all the left children of the current node onto the stack, and when we call next(), 
we pop from the stack and push the right child of that node (if it exists) onto the stack.

*/

import java.util.*;

public class BSTIterator {
    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {

        st = new Stack<>();

        TreeNode node = root;

        dfs(node);

    }

    /** @return the next smallest number */

    public int next() {

        TreeNode node = st.pop();

        dfs(node.right);

        return node.val;

    }

    /** @return whether we have a next smallest number */

    public boolean hasNext() {

        return !st.isEmpty();

    }

    private void dfs(TreeNode node) {

        while (node != null) {

            st.push(node);

            node = node.left;

        }

    }

}
