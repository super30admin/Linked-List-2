//https://leetcode.com/problems/binary-search-tree-iterator/
//TC:o(1) - as we are not iterating through the entire tree at once next and has next is o(1)
//SC:o(h)


class BSTIterator {

    Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        inorder(root);
    }
    private void inorder(TreeNode root){
        while(root!=null){
            stack.push(root);
            root=root.left;
        }
    }
    public int next() {
        TreeNode next = stack.pop();
        //lazy load the right sub tree
        inorder(next.right);
        return next.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
