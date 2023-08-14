class BSTIterator {
    List<Integer> list;
    int next = 0; //initial index;

    public BSTIterator(TreeNode root) {
        this.list = new ArrayList<>();
        
        dfs(root); //collect all the values to the given list using 
in-order traversal of tree
    }
    
    public int next() {
        return  list.get(next++);
    }
    
    public boolean hasNext() {
        return list.size() > next;
    }
   
    private void dfs(TreeNode root) {
        if(root == null) {
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}
