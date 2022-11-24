//Time complexity is O(N)
//Space complexity is O(N)
class BSTIterator {
    List<Integer> li = new ArrayList();
    Integer index;
    public BSTIterator(TreeNode root) {
        index=0;
        helper(root);
    }
    public void helper(TreeNode root){
        if(root==null){
            return;
        }
        helper(root.left);
        li.add(root.val);
        helper(root.right);
    }

    
    public int next() {
        index=index+1;
        return li.get(index-1);
    }
    
    public boolean hasNext() {
        return index<li.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */