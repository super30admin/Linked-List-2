// This is a controlled recursive approach, in this method we use our own stack insead of system stack to control the recursion. 
// Initiall all the nodes are added into the stack until the leftmost node of the stack. If the top of the stack is the leaf node, it is all fine, but if it's not
// we need to explore all the nodes towards the right of the current node. It will take additional time. 

// Time Complexity: O(1) amortized time, but in the worst case the next() method can take O(N) time. 
// Space Complexity: O(n)

import java.util.Stack;

public class BSTIterator {

    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        this.stack = new Stack<TreeNode>();
        this.leftInorder(root);
    }

    private void leftInorder(TreeNode root) {
        while (root != null) {
            this.stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode top = this.stack.pop();
        if (top.right != null) {
            this.leftInorder(top.right);
        }
        return top.val;
    }

    public boolean hasNext() {
        return this.stack.size() > 0;
    }

}
