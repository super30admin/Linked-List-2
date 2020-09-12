//Time Complexity: O(n) where n is the maximum depth of the tree
//Space Complexity: hasNext: O(1) next: O(n)

import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> s;
    //initilaize stack and push all left nodes in stack
    public BSTIterator(TreeNode root) {
        s = new Stack<>();
        check(root);
    }
    
    //check if stack has value which would be the smallest then push that and check if the node has right then push that node and check for its left
    /** @return the next smallest number */
    public int next() {
        TreeNode p = s.pop();
        check(p.right);
        return p.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s.isEmpty();
    }
    
    //push all left elements in stack
    public void check(TreeNode root){
        while(root != null){
            s.add(root);
            root = root.left;
        }
    }

    public static class TreeNode {
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
