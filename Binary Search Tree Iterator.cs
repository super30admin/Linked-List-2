/*
  Amortized Time complexity: O(1)
  Space complexity: O(h)

  Code executed successfully on Leetcode: Yes
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new();

        while(root!=null)
        {
            stack.Push(root);
            root = root.left;
        }
    }
    
    public int Next() {
        TreeNode top = stack.Pop();

        TreeNode right = top.right;
        if(right!=null)
        {
            while(right!=null)
            {
                stack.Push(right);
                right = right.left;
            }
        }

        return top.val;
    }
    
    public bool HasNext() {
        return stack.Count>0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.Next();
 * bool param_2 = obj.HasNext();
 */
