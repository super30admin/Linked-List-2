//Leetcode - 173
//TC - O(H) - worst case, O(1) - Average case
//SC - O(H)
import java.util.Stack;

public class BSTIterator {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        this.st = new Stack<>();
        dfs(root);
    }
    private void dfs(TreeNode root) {
        while(root != null) {
            st.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode node = st.pop();
        dfs(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }
    //Extra space
    /*private List<Integer> list;
    private int i;
    public BSTIterator(TreeNode root) {
        this.list = new ArrayList<>();
        inorder(root);

    }
    private void inorder(TreeNode root) {
        //base
        if(root==null) return;

        //logic
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    public int next() {
        int res = list.get(i);
        i++;
        return res;
    }

    public boolean hasNext() {
        return i!=list.size();

    }*/
}
