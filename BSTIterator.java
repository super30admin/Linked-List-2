import java.util.Stack;

// Time Complexity : next() : O(1), hasNext() : O(1)
// Space Complexity : O(H) H is the height of BST
// Did this code successfully run on Leetcode :Y
// Any problem you faced while coding this :
public class BSTIterator {
    
    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        this.st = new Stack<>();
        dfs(root);
    }

    public void dfs(TreeNode root)
    {
        while(root!=null)
        {
            st.push(root);
            root = root.left;

        }
    }
    
    public int next() {
        TreeNode re = st.pop();
        dfs(re.right);
        return re.val;

    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);    
    BSTIterator obj = new BSTIterator(root);
    while(obj.hasNext())
    {
        System.out.println(obj.next());
    }
    }
}

