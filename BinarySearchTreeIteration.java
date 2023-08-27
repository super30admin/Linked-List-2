// TC = O(n)
//SC = O(n)

class BinarySearchTreeIteration{
    
    List<Integer> li;
    int i = 0;
    public BSTIterator(TreeNode root) {
        li = new ArrayList<>();
        inorder(root);
    }
    
    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        li.add(root.val);
        inorder(root.right);
    }

    public int next() {
        int res = li.get(i);
        i++;
        return res;
    }
    
    public boolean hasNext() {
        return i != li.size();
    }

}
