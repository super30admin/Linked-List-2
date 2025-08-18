import java.util.Stack;

import javax.swing.tree.TreeNode;

public class Binarysearchiterator{
    //Maintain stack to store elements. whenever we pop-up elements, its right sub-tree elements are pushed into stack
    //Time Complexity: O(logn)
    //Space Complexity: O(logn)
    Stack<TreeNode> stk;
    public BSTIterator(TreeNode root) {
        this.stk = new Stack<>();
        helper(root);
    }
    
    private void helper(TreeNode root)
    {
        while(root!=null)
        {
            stk.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode temp = stk.pop();
        helper(temp.right);
        return temp.val;
    }
    
    public boolean hasNext() {
        return !stk.isEmpty();
    }
}