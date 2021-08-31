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
 //Time Complexity : O(1) for Next and HasNext
 //Space Complexity: O(1) as we are storing one next element to Stack
public class BSTIterator {
    Stack<TreeNode> s;
    public BSTIterator(TreeNode root) {
         s = new Stack<TreeNode>();
         dfs(root);
    }
    
    public int Next() {
        if (s.Count == 0) return -1;
        TreeNode node = s.Pop();
        dfs(node.right);
        return node.val; 
    }
    
    public bool HasNext() {
        return (s.Count!=0);
    }
    
    private void dfs(TreeNode root)
    {
        while (root != null)
        {
            s.Push(root);
            root = root.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.Next();
 * bool param_2 = obj.HasNext();
 */