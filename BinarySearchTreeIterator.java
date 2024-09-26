// Time Complexity : O(1) for next and hasNext , O(h) for DFS
// Space Complexity : O(h) extra space used.
// Any problem you faced while coding this :


// we use a stack to store elements when executing DFS in left side of tree, then pop then dfs on right side of tree.   
//Success
//Details 
 // Runtime: 15 ms, faster than 92.66% of Java online submissions for Binary Search Tree Iterator.
//  Memory Usage: 44.8 MB, less than 100.00% of Java online submissions for Binary Search Tree Iterator.

class BSTIterator {
   Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
      stack=new Stack<>();
      dfs(root);
    }
    
    private void dfs(TreeNode root){
        while (root!=null){
            stack.push(root);
            root=root.left;
        }
    }
    /** @return the next smallest number */
    public int next() {
       TreeNode node=stack.pop();
       dfs(node.right); 
       return node.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();  
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */