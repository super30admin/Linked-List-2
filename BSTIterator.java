import javax.swing.tree.TreeNode;

public /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    //Time Complexity: O(h)
    //Space Complexity: O(h)
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode node = root;
        while (node != null){
            stack.push(node);
            node = node.left;
        }
    }

    public int next() {
        if (!hasNext()) return -1;
        TreeNode node = stack.pop();
        TreeNode right = node.right;

        while (right != null){
            stack.push (right);
            right = right.left;
        }
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}