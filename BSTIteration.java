import java.util.Stack;

public class BSTIteration {
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
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        inorder(root);
    }

    public int next() {
        TreeNode res = st.pop();
        inorder(res.right);
        return res.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

    private void inorder(TreeNode root){
        while(root != null){
            st.push(root);
            root = root.left;
        }
    }
}
