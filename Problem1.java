// Time Complexity : O(N) -> N = number of elements in the tree
// Space Complexity : O(H + N) -> H = height of the tree, N = length of the arraylist
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Was thinking another way before utilizing BST properties.


// Your code here along with comments explaining your approach

// Utilizing the property of a BST where the left child's 
// value is always less than the right child's value
// Also performing inorder search in a BST always yields
// a sorted order of elements.

class BSTIterator {

    ArrayList<Integer> sortedNodes;
    int index;
    
    public BSTIterator(TreeNode root) {
        
        this.sortedNodes = new ArrayList<Integer>();
        this.index = -1;
        this.inorder(root);
    }
    
    private void inorder(TreeNode node) {
        
        if (node == null) return;
        this.inorder(node.left);
        sortedNodes.add(node.val);
        this.inorder(node.right);
    }
    
    /** @return the next smallest number */
    public int next() {
        return this.sortedNodes.get(++index);
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return this.index + 1 < this.sortedNodes.size(); 
    }
}
