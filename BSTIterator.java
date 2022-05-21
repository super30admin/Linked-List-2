// making use of stack to perform what i call 'controlled recursion' where dfs is used to traverse through left most nodes and store it in stack
// at every next() call we pop the topp of stack and see if it has right children. repeat this 
// tc: amortized is o(1) cuz the push int0 stack occurs only once in a while most of time we be poppin'
// sc: o(H) where H is height of tree
class BSTIterator {
    Stack<TreeNode> s;
    public BSTIterator(TreeNode root) {
        s = new Stack<>();
        dfs(root);
    }
    
    public int next() {
        TreeNode result = s.pop();
        dfs(result.right);
        return result.val;
    }
    
    public boolean hasNext() {
        return !s.isEmpty();
    }
    private void dfs(TreeNode root) {
        while(root != null) {
            s.push(root);
            root = root.left;
        }
    }
}
