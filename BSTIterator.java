//Average Time Complexity O(1)
//Space Complexity O(h)
//Leetcode tested

import java.util.Stack;

class BSTIterator {
    Stack<TreeNode> st = new Stack<>();
    public BSTIterator(TreeNode root) {
        partialInOrder(root);
    }
    public void partialInOrder(TreeNode root){
        while (root!=null){
            st.push(root);
            root=root.left;
        }
    }

    public int next() {
        TreeNode top = st.pop();
        partialInOrder(top.right);
        return top.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }
}
