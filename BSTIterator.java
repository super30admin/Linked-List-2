// Time Complexity : ammortized O(1)
// Space Complexity : O(h)


class BSTIterator {
    private LinkedList<TreeNode> li;
    public BSTIterator(TreeNode root) {
        li= new LinkedList();
        inorder(root);
    }
    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        li.add(root);
        inorder(root.right);
    }
    public int next() {
        TreeNode re = li.poll();
        return re.val;
    }

    public boolean hasNext() {
        if(li.size()>0)return true;
        return false;
    }
}


//not accepted
class BSTIterator {
    private LinkedList<TreeNode> li;
    public BSTIterator(TreeNode root) {
        li= new LinkedList();
        inorder(root);
    }
    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        li.add(root);
        inorder(root.right);
    }
    public int next() {
        TreeNode re = li.poll();
        return re.val;
    }

    public boolean hasNext() {
        if(li.size()>0)return true;
        return false;
    }
}