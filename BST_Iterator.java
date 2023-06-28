// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// WE implement the iterator using a stack. In the constructor of BSTIterator,we perform a depth-first search(DFS)on the BST,starting from the root.During the DFS,we traverse to the left child of each node until we reach a leaf node,pushing all the nodes encountered onto the stack.This ensures that the leftmost node(smallest value)in the BST is at the top of the stack. The hasNext() method simply checks if the stack is empty or not. If the stack is not empty, it means there are more elements to iterate over. While the next() method is used to retrieve the next smallest element from the BST. We pop a node from the top of the stack, which represents the current smallest element. Then, if the popped node has a right child, we perform a DFS on its right subtree, pushing all the nodes encountered onto the stack. This ensures that the next smallest element in the BST will be at the top of the stack for the next next() call.

import java.util.Stack;

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

public class BST_Iterator {
    Stack<TreeNode> st;

    public BST_Iterator(TreeNode root) {
        this.st = new Stack<>();
        dfs(root);
    }

    private void dfs(TreeNode root) {
        // if(root == null) return;
        while (root != null) {
            st.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode popped = st.pop();
        dfs(popped.right);
        return popped.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BST_Iterator obj = new BST_Iterator(root);
        while (obj.hasNext()) {
            int nextVal = obj.next();
            System.out.print("Next Val: " + nextVal + "\n");
        }
    }
}
