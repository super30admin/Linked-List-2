// Time Complexity :
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach :
// To load only the next value in the BST we need to push the leftmost node in the tree. If next() is called on the tree,
// the left node should be popped and returned. Also, the right node of the child should be pushed, so that it is processed
// on the next next() call.
import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        dfs(root);
    }

    private void dfs(TreeNode root) {
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }
    // O(1) - amortized
    public int next() {
        TreeNode nextValue = stack.pop();
        if(nextValue.right != null){
            dfs(nextValue.right);
        }
        return nextValue.val;
    }
    // O(1)
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
