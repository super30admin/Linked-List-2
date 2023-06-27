// Time Complexity : O(1)
// Space Complexity : O(h) height of the tree

class Solution {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        this.st=new Stack<>();
        inorder(root);
    }
    private void inorder(TreeNode root){
        while(root!=null)
        {
            st.push(root);
            root=root.left;
        }
    }

    public int next() {
        TreeNode popped = st.pop();
        inorder(popped.right);
        return popped.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }
}

