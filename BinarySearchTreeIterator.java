/**
 * Time Complexity:
 * BSTIterator(TreeNode root): O(H)
 * next(): O(1) on average
 * hasNext(): O(1)
 * Space Complexity: O(H)
 */

class BSTIterator {

    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {

        push(root);
    }

    public int next() {
        TreeNode tempNode = stack.pop();
        push(tempNode.right);
        return tempNode.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void push(TreeNode node) {

        while(node != null) {
            stack.push(node);
            node = node.left;
        }

    }
}