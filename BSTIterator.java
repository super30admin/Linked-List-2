// Time Complexity : O(h) worst in case of next() where h is the height of bst, and amortized O(1) .
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
import java.util.*;
public class BSTIterator {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }
    private Stack<TreeNode> stk;
    public BSTIterator(TreeNode root) {
        this.stk = new Stack<>();
        dfs(root);
    }
    public void dfs(TreeNode node) {
        while(node != null) {
            stk.push(node);
            node = node.left;
        }
    }
    public int next() {
        TreeNode temp = stk.pop();
        dfs(temp.right);
        return temp.val;
    }

    public boolean hasNext() {
        return (!stk.isEmpty());
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode (7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator it = new BSTIterator(root);
        /*
                   7
                  / \
                 3   15
                    /  \
                   9   20
        */

        while ((it.hasNext())) {
            System.out.print(it.next() + "   ");
        }

    }
}

