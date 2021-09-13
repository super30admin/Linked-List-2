// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class BSTIterator {
    List<Integer> nodesSorted;
    int index;
    public BSTIterator(TreeNode root) {
        this.index = -1;
        this.nodesSorted = new ArrayList<>();
        this.inorder(root);
    }
    
    private void inorder(TreeNode root) {
        if(root == null)
            return;
        this.inorder(root.left);
        this.nodesSorted.add(root.val);
        this.inorder(root.right);
    }
    
    public int next() {
        return this.nodesSorted.get(++index);
    }
    
    public boolean hasNext() {
        return index + 1 < this.nodesSorted.size() ? true : false;
    }
}