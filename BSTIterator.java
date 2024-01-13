// Time Complexity :O(1)
// Space Complexity :O(H)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach: I use Stack to push and pop the element
class BSTIterator {
    private Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack=new Stack<>();
        while(root!=null){
            stack.push(root);
            root=root.left;
        }
    }
    
    public int next() {
        if (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode right = node.right;
            while (right!= null) {
                stack.push(right);
                right = right.left;
            }
            return node.val;
        }
        return -1;
    }
    
    public boolean hasNext() {
        
        return !stack.isEmpty();
    }
}
