//Time Complexity : O(1)
//Space Complexity : O(1)


class BSTIterator {
    List<TreeNode> l;
    int idx;
    public BSTIterator(TreeNode root) {
        this.l = new ArrayList<>();
        inorder(root);
    }
    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        l.add(root);
        inorder(root.right);
    }
    
    public int next() {
        TreeNode curr = l.get(idx);
        idx++;
        return curr.val;
    }
    
    public boolean hasNext() {
        return idx != l.size();
    }
}
