/**
 * // Time Complexity : O(n)
 // Space Complexity : O(h) h = height of tree.
 // Did this code successfully run on Leetcode : yes

 // Your code here along with comments explaining your approach
  //using controlled recursion.
  //get the left most elems and store in stack on initilization.
  //on next, pop the top of stack and check for any right nodes.
  //get all the left elems of this right node.
 */
class BSTIterator {
    TreeNode root = null;
    Stack<TreeNode> stk = null; //12
    public BSTIterator(TreeNode root) {
        TreeNode node = root;
        this.root = root;
        stk = new Stack<>();

        //get everything till left most node.
        while(node != null){
            stk.push(node);
            node = node.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode ret = stk.pop();

        TreeNode node = ret.right;
        //get everything till left most node.
        while(node != null){
            stk.push(node);
            node = node.left;
        }
        return ret.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (!stk.isEmpty());
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
