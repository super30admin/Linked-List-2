// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class BSTIterator {
  Stack<TreeNode> stack;


    public BSTIterator(TreeNode root) {
        stack = new Stack <> ();
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
        
    }
    public int next() {
        // Pop the smallest node (top of stack)
        TreeNode node = stack.pop();
    
    // If it has a right child, go left as far as possible from there
        TreeNode right = node.right;
        while (right != null) {
            stack.push(right);
            right = right.left;
        }

        return node.val;
    }
    
    
    public boolean hasNext() {
        return !stack.isEmpty();
        
    }
}
///
/// 