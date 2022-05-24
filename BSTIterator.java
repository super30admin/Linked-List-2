public class BSTIterator {
    List<Integer> inorder;
    int current = 0;
    private void helper(TreeNode root){
        if(root == null){
            return;
        }
        helper(root.left);
        inorder.add(root.val);
        helper(root.right);
    }

    public BSTIterator(TreeNode root) {
        inorder = new ArrayList<>();
        helper(root);
    }
    
    public int next() {
        return inorder.get(current++);
    }
    
    public boolean hasNext() {
        if(current == inorder.size()){
             return false;
        }
        else{
            return true;
        }
    }
}
