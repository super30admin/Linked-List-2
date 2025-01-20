//TC: O(N)- to create the List
 //SC: O(N) - list 
 class BSTIterator {

    List<Integer> inOrder;
    int idx ;
    public BSTIterator(TreeNode root) {
        this.inOrder = new ArrayList<>();
        inOrderList(root);
        this.idx = 0;
   
    }

    private void inOrderList(TreeNode root){
        if(root == null)return;
        if(root.left != null) inOrderList(root.left);
        inOrder.add(root.val);
        if(root.right != null) inOrderList(root.right);
    }
    
    public int next() {
        if(hasNext()){
            return inOrder.get(idx++);
        }
        return -1;
    }
    
    public boolean hasNext() {
        if(idx == inOrder.size()) return false;
        return true;
    }
}
