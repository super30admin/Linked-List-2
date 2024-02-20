// ## Problem1 (https://leetcode.com/problems/binary-search-tree-iterator/)
// Time Complexity : Ammortized O(1)
// Space Complexity : O(H), where H is the height of input tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class BSTIterator {
    // Simulate an inOrder traversal call-stack
    private Stack<TreeNode> inOrderSt;

    private void helper(TreeNode root){
        if(root==null){
            return;
        }
        while(root!=null){
            this.inOrderSt.add(root);
            root=root.left;
        }
    }

    public BSTIterator(TreeNode root) {
        inOrderSt=new Stack<>();
        helper(root);
    }
    
    public int next() {
        TreeNode curr=inOrderSt.pop();
        // Add right sub-tree to stack
        helper(curr.right);
        return curr.val;
    }
    
    public boolean hasNext() {
        return inOrderSt.size()!=0;
    }
}
