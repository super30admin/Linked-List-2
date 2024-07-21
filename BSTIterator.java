import java.util.*;
//Time - all operations O(1). next() has avg ie amortized as O(1) and worst case O(h)
//Space - O(h)
class BSTIterator {

    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack();
        dfs(root);
        return;
    }

    private void dfs(TreeNode root) {
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode popped = stack.pop();
        dfs(popped.right);
        return popped.val;
    }

    public boolean hasNext() {
        if(!stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}