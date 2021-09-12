/*
Time: Next() is Amortized O(1), hasNext() is O(1)
Space: O(h)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class BSTIterator {

    Stack<TreeNode> stack = new Stack();

    public BSTIterator(TreeNode root) {
        // partialorder
        partialInOrder(root);

    }

    void partialInOrder(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public int next() {
        TreeNode top = stack.pop();
        partialInOrder(top.right); // when ever you see a right, push the right into the stack
        return top.val;

    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

}