//Time Complexity O(length of tree)
//Space Complexity O(length of tree)
//Leetcode tested

import java.util.Stack;

public class ValidBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        java.util.Stack<TreeNode> stack = new Stack<>();
        double left_child_val=-Double.MAX_VALUE;
        while (!stack.isEmpty() || root!=null){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            if(root.val<=left_child_val)
                return false;
            left_child_val=root.val;
            root=root.right;
        }
        return true;
    }
}
