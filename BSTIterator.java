import java.util.Stack;

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

public class BSTIterator {

    // TC: next() - Amortized complexity O(1). Very rarely we will go to the extreme left
    // SC: O(h)  h -> height of the tree
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        dfs(root);
    }

    public int next() {
        TreeNode temp = stack.pop();
        dfs(temp.right);
        return temp.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void dfs(TreeNode root) {
        while(root != null){
            stack.push(root);

            root = root.left;
        }
    }
}
