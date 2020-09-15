// Time Complexity :O(N)
// Space Complexity :O(H)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//1.Traverse through the elements and consider a stack that would store the minimum elements.
//2. ELements are traversed using inorder traversal.

import java.util.*;

public class BSTIterator {
    static class TreeNode {
        int val;
        TreeNode right, left;

        TreeNode(int ele) {
            val = ele;
        }
    }

    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        dfs(root);

    }

    /** @return the next smallest number */
    public int next() {
        TreeNode ans = st.pop();
        if (ans.right != null) {
            dfs(ans.right);
        }
        return ans.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !st.isEmpty();
    }

    public void dfs(TreeNode root) {
        while (root != null) {
            st.push(root);
            root = root.left;

        }
    }

    public static void main(String args[]) {
        TreeNode tree = new TreeNode(7);
        tree.left = new TreeNode(3);
        tree.right = new TreeNode(15);

        tree.right.left = new TreeNode(9);
        tree.right.right = new TreeNode(20);
        BSTIterator obj = new BSTIterator(tree);
        int param_1 = obj.next();
        int param_3 = obj.next();
        boolean param_2 = obj.hasNext();
        System.out.println(param_1);
        System.out.println(param_3);
        System.out.println(param_2);
    }
}
