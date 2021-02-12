// Time Complexity : O(n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
// use stack to store our inorder sequence
class BSTIterator {

    Stack<TreeNode> s;
    public BSTIterator(TreeNode root) {
        s = new Stack();
        dfs(root);
    }
    
    private void dfs(TreeNode root) {
        while(root!=null) {
            s.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        if(!hasNext()) return -1;
        
        TreeNode root = s.pop();
        dfs(root.right);
        
        return root.val;
    }
    
    public boolean hasNext() {
        return !s.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
