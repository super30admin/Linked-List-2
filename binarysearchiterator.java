/*
Time Complexity:O(1)
Space Complexity:O(1)
*/
public class BSTIterator {
    TreeNode node;
    Stack<TreeNode> stack = new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        node = root;
    }

    public boolean hasNext() {
        return node != null || stack.size() != 0;
    }

    public int next() {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }

        node = stack.pop();
        int r = node.val;
        node = node.right;
        return r;
    }
}