
//  TC: O(1)
// SC: O(n)
 //Learn difference between Iterator and Recession
 class BSTIterator {
    List<Integer> list;
    int idx;

    public BSTIterator(TreeNode root) {
        this.list = new ArrayList<>();
        this.idx = 0;
        dfs(root);
        
    }
    private void dfs(TreeNode root){
        if(root == null) return;

        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
    
    public int next() {
       return list.get(idx++);
    }
    
    public boolean hasNext() {
        return idx < list.size();
    }
}
