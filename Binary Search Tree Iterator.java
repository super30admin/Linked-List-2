// Time Complexity : O(1), Amortized. Only in case of left child we will have O(h) just for the first left child call 
// Space Complexity : O(h), where h is the height of the tree.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class BSTIterator {
    Stack<TreeNode> s;
    public BSTIterator(TreeNode root) {
        if(root==null) return;
        s = new Stack<>();
        dfs(root);
    }
    
    public int next() {
        TreeNode res = s.pop();
        dfs(res.right);
        return res.val;
    }
    
    public boolean hasNext() {
        return !s.isEmpty();        
    }
    private void dfs(TreeNode root){
        if(root==null)
            return;
        while(root!=null){
            s.push(root);
            root = root.left;
        }
    }
}