// Time complexity: O(N)
// Space complexity: O(N)
// Brute force approach - perform inorder traversal and store all node values into an arraylist, then just use an index and
// return the element at the index. This is not a good approach as we are filling the arraylist with all the current nodes
// of the tree. But let's say if the tree is changed or a node is added or removed, this iterator will not work. Iterator is
// supposed to be dynamic and should just care about the next node and nothing else and should not be affected
// by addition or removal of nodes in the rest of the tree and should be able to still work. This brute force approach works
// here but should not be the solution in the interview

class BSTIterator {
    List<Integer> list;
    int idx = 0;
    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        inorderHelper(root);
    }
    
    private void inorderHelper(TreeNode root) {
       if (root == null) return;
       inorderHelper(root.left);
       list.add(root.val);
       inorderHelper(root.right);
    }
    
    public int next() {
        return list.get(idx++);
    }
    
    public boolean hasNext() {
        return idx < list.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */