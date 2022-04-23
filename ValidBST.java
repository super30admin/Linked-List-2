// Time Complexity : O(N)
// Space Complexity : O(H) where H is height of tree
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
import java.util.*;
public class ValidBST {
    
    public static boolean isValidBST(TreeNode root)
    {
        if(root == null)
        {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;

        while(root!=null || !stack.isEmpty())
        {
            while(root!=null)
            {
                stack.push(root);
                root=root.left;
            }
            root = stack.pop();

            if(prev!=null && prev.val>=root.val)
            {
                return false;
            }
            prev = root;
            root = root.right;
        }

        return true;
        
    }
}
