// Time Complexity : O(h)
// Space Complexity :O(n) 
class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack=new Stack<>();
        dfs(root);
    }
    
    public int next() {
        TreeNode temp=stack.pop();
        dfs(temp.right);
        return temp.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    private void dfs(TreeNode root){
        while(root!=null){
            stack.push(root);
            root=root.left;
        }
    }
}

