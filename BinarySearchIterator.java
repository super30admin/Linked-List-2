/**
 * Space complexity O(n) - worst case ---- O(h) - average case
 * Time complexity of hasNext is O(1) - next O(n) - worst case ---- O(h) - average case
 */
import java.util.Stack;

class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        push(root);
    }
    
    public int next() {
        TreeNode node = stack.pop();
        push(node.right);
        return node.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    private void push(TreeNode node) {
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
    }
    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; }
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
        }
    }
}