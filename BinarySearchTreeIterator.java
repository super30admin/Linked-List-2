// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Iterator should have access to only the next element of the tree and not to all the nodes incase of inorder traveral. 
public class BinarySearchTreeIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        dfs(root);
    }
    
    public void dfs(TreeNode root){
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode node = stack.pop();
        dfs(node.right);
        return node.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
