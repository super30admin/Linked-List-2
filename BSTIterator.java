import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        this.st=new Stack<>();
        dfs(root);
    }

    private void dfs(TreeNode root){
        while(root!=null){
            st.push(root);
            root=root.left;
        }
    }

    public int next() {
        TreeNode curr=st.pop();
        dfs(curr.right);
        return curr.val;

    }

    public boolean hasNext() {
        return !st.empty();
    }
}