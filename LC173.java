class BSTIterator {
    
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        dfs(root);
    }
    
    public int next() {
        TreeNode pop = stack.pop();
        if(pop.right != null){
            dfs(pop.right);
        }
        return pop.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    public void dfs(TreeNode root){
        while(root != null){
            stack.add(root);
            root = root.left;
        }
    }
}

//Time complexity: O(1) Worst case-O(h)
//Space Complexity:O(h)