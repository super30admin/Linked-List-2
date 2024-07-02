import java.util.*;

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

class BSTIterator {

    Stack<TreeNode> s;

    public BSTIterator(TreeNode root) {
        s = new Stack<>();
        dfs(root);
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
        while (root != null) {
            s.push(root);
            root = root.left;
        }
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        BSTIterator b = new BSTIterator(root);
        int param_1 = b.next();
        System.out.println(param_1);
        System.out.println(b.next());
        boolean param_2 = b.hasNext();
        System.out.println(param_2);
    }
}
