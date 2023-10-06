import java.util.ArrayList;
import java.util.List;

/**
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
//SC: O(N)
class BSearchTreeIterator {
    List<Integer> li;
    private int i; // working on li
    public BSearchTreeIterator(TreeNode root) {
        this.li = new ArrayList<>();
        inorder(root);
    }
    //TC: O(N)
    private void inorder(TreeNode root) {
        //base
        if(root == null) return;
        //logic
        inorder(root.left);
        li.add(root.val);
        inorder(root.right);
    }
    //TC: O(1)
    public int next() {
        return li.get(i++);
    }
    //TC: O(1)
    public boolean hasNext() {
        return i != li.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */