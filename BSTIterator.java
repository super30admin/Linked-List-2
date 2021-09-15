import java.util.*;

class BSTIterator {

    Stack<TreeNode> stk = new Stack<>();
    Queue<TreeNode> finalStk = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }

            root = stk.pop();
            finalStk.add(root);
            root = root.right;
        }
    }

    public int next() {
        if (!finalStk.isEmpty())
            return finalStk.remove().val;
        else
            return 0;
    }

    public boolean hasNext() {
        return !finalStk.isEmpty();
    }
}
