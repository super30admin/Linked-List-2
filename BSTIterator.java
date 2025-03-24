import java.util.Stack;
//TC-O(N) O(h)  ,next -O(1) , hasNext -O(1)
public class BSTIterator {
    Stack<TreeNode> s;

    public BSTIterator(TreeNode root) {
        s = new Stack<>();
        TreeNode node = root;
        dfs(node);
    }

    public int next() {
        TreeNode node = s.pop();
        dfs(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return !s.isEmpty();
    }

    public void dfs(TreeNode root) {
        while (root.left != null) {
            s.push(root);
            root = root.left;
        }
    }

    public class TreeNode {
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
}