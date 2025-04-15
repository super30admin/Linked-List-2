import java.util.Stack;

public class binarySearchTreeIterator 
{
    public class TreeNode 
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) 
        {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    class BSTIterator 
    {
        Stack<TreeNode> st;
        TreeNode root ;
        public void addToStack(TreeNode rootadd)
        {
            while(rootadd != null)
            {
                st.add(rootadd);
                rootadd = rootadd.left;
            }
        }
        public BSTIterator(TreeNode root) {
            this.root  = root;
            st = new Stack<>();
            addToStack(root);
        }
        
        public int next() 
        {
            if(!st.isEmpty())
            {
                TreeNode rootdup = st.pop();
                int x = rootdup.val;
                addToStack(rootdup.right);
                return x;
            }
            else
            {
                return -1;
            }
        }
        
        public boolean hasNext() 
        {
            if(st.isEmpty())
            {
                return false;
            }
            return true;
        }
    }
}
