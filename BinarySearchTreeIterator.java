class BSTIterator {
    
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        leftMostInorderRoot(root);
    }
    
    private void leftMostInorderRoot(TreeNode root){
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode topNode = stack.pop();
        
        if(topNode.right!=null){
            leftMostInorderRoot(topNode.right);
        }
        
        return topNode.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

Time Complexity:
next() -> Amortised O(1)
hasNext() -> O(1)

Space Complexity: O(n)