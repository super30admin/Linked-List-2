import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        while(root!=null){
            st.push(root);
            root = root.left;
        }

    }

    public int next() {
        TreeNode popped = st.pop();
        TreeNode next = popped.right;
        while(next!=null){
            st.push(next);
            next=next.left;
        }
        return popped.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();

    }
}
