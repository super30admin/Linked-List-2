//Time = O(h) for each call to next(), where h is the height of the binary search tree
//Space = O(h) because we are using a stack to store the left nodes of each node.

import java.util.*;

public class BSTIterator {
    Stack<TreeNode> stack; // Declare a stack to store nodes
    
    // Constructor for the iterator - initialize stack with left nodes of root
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushLeft(root);
    }
    
    // Method to return next element in the iterator
    public int next() {
        // Pop the top node from the stack
        TreeNode node = stack.pop();
        // Push all the left nodes of the right child of the popped node onto the stack
        pushLeft(node.right);
        // Return the value of the popped node
        return node.val;
    }
    
    // Method to check if there are more elements in the iterator
    public boolean hasNext() {
        // If the stack is not empty, there are more elements in the iterator
        return !stack.isEmpty();
    }
    
    // Helper method to push all the left nodes of a given node onto the stack
    private void pushLeft(TreeNode node) {
        // While the node is not null
        while (node != null) {
            // Push the node onto the stack
            stack.push(node);
            // Move to the left child of the node
            node = node.left;
        }
    }
}

// TreeNode class to represent a node in the binary search tree
class TreeNode {
    int val; // Value of the node
    TreeNode left; // Left child of the node
    TreeNode right; // Right child of the node
    
    // Constructor for the TreeNode class
    TreeNode(int x) { val = x; }
}
  
