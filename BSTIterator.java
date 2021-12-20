//Time Complexity : O(n)
//Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


class BSTIterator {
    ArrayList<Integer> nodesSorted;
    int index;
    public BSTIterator(TreeNode root) {
        this.nodesSorted = new ArrayList<>();
        this.index = -1;
        this.inOrder(root);
    }

    public int next() {
        return this.nodesSorted.get(++this.index);
    }

    public boolean hasNext() {
         return this.index + 1 < this.nodesSorted.size();
    }
    public void inOrder(TreeNode root){
        if(root == null)
            return;
        this.inOrder(root.left);
        this.nodesSorted.add(root.val);
        this.inOrder(root.right);
    }
}
