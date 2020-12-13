// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
class BSTIterator {
    
    List<Integer> inorder = new ArrayList();
    int currIndex = 0;
    int max = Integer.MIN_VALUE;
    public BSTIterator(TreeNode root) {
        
        dfs(root);
        max = inorder.size();        
    }
    
    public void dfs(TreeNode node) {
        
        if(node == null)
            return;        
        dfs(node.left);
        inorder.add(node.val);
        dfs(node.right);        
    }
    
    public int next() {
        
        return inorder.get(currIndex++);        
    }
    
    public boolean hasNext() {
        
        return currIndex < max;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
