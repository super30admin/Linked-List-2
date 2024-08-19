//Avg Time Complexity: O(1)
import java.util.Stack;

class BinarySearchTreeIterator {
    Stack<TreeNode> st;
    public BinarySearchTreeIterator(TreeNode root) {
        this.st = new Stack<>();
        dfs(root);
    }

    public void dfs(TreeNode root){
        while(root!=null){
            st.push(root);
            root = root.left;
        }
    }
    public int next() {
        TreeNode result = st.pop();
        dfs(result.right);
        return result.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }
}
