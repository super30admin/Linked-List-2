// Time Complexity : O(n) where n is equal to number of nodes
// Space Complexity : O(h) or O(log n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Initially stored the complete inorder traversal of the tree 

// Your code here along with comments explaining your approach
// Given space constraint is O(h) and we need to return next() (least) element in BST, we take the idea from recursion stack during inorder traversal  
// push root and recursively push all its left children to stack till we reach leaf node, this would be the least element
// on next() pop() and return value
// if popped element has a right child call the same method, (recursively push all left nodes) on right child
// this way no items in stack are always equal to a branch and next() is O(1) on average

class BSTIterator {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    
    public BSTIterator(TreeNode root) {
        dfs(root);
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode poppedNode = stack.pop();
        if(poppedNode.right!=null){
            dfs(poppedNode.right);
        }
        return poppedNode.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    private void dfs(TreeNode root){
        if(root==null) return;
        while(root!=null){
            stack.push(root);    
            root = root.left;
        }
    }
}