// Time Complexity : O(1) for next() and hasNext() methods, O(h) for constructor where h is the height of the tree
// Space Complexity : O(h) where h is the height of the tree, due to the stack used to store nodes
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    nO


// Your code here along with comments explaining your approach


// We are using a stack to store the nodes of the BST.
//  In the constructor, we push all the left nodes of the root onto the stack.
// In the next() method, we pop the top node from the stack, which is the next smallest element in the BST.
// We then push all the left nodes of the right child of the popped node onto the stack.
// The hasNext() method simply checks if the stack is empty or not. If the stack is not empty, it means there are still nodes left to visit in the BST.
import java.util.*;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class BSTIterator {

    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {

        stack = new Stack<>();

        pushLeftNodes(root);
    }

    private void pushLeftNodes(TreeNode root) {

        while (root != null) {

            stack.push(root);

            root = root.left;
        }
    }

    public int next() {

        TreeNode node = stack.pop();

        pushLeftNodes(node.right);

        return node.val;
    }

    public boolean hasNext() {

        return !stack.isEmpty();
    }
}