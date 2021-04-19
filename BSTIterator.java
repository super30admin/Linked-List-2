// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
class BSTIterator {
    Deque<TreeNode> stack; 
    public BSTIterator(TreeNode root) {
        stack = new ArrayDeque();
        process(root);
    }
    
    // Time Complexity : O(n) 
    // Space Complexity : O(n)
    public int next() {
        TreeNode root = stack.pop();
        int ans = root.val;
        root=root.right;
        process(root);
        return ans;
    }
    
    // Time Complexity : O(1) 
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    private void process(TreeNode root){
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
    }
}