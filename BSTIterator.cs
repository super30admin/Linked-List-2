// time Complexity - next and hasNext will take O(1) time
// space complexity - next and hasNext will take O(1) space
// Approach - We will be processing only left elements to a node at a time by adding them in stack 
// and when next is called, we will be processing right elements to it.
// For hasNext function we will check if stack is empty or not
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
public class BSTIterator
{
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root)
    {
        st = new Stack<TreeNode>();
        TreeNode node = root;
        dfs(node);
    }

    public int Next()
    {
        TreeNode node = st.Pop();
        dfs(node.right);
        return node.val;
    }

    public bool HasNext()
    {
        return !(st.Count() == 0);
    }

    private void dfs(TreeNode node)
    {
        while (node != null)
        {
            st.Push(node);
            node = node.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.Next();
 * bool param_2 = obj.HasNext();
 */