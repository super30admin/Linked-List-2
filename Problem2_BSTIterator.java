import java.util.Stack;

// Time Complexity : o(n)
// Space Complexity : o(1) for hasnext and next o(h) for pushing
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class BSTIterator {

    Stack<TreeNode> stack;
    
    public BSTIterator(TreeNode root) {
        
        stack=new Stack<TreeNode>();
        
        controlledDFS(root);
        
    }
    
    public void controlledDFS(TreeNode root)
    {
        while(root!=null)
        {
            stack.push(root);
            root=root.left;
        }
    }
    public int next() {
           TreeNode temp=stack.pop();
            
            if(temp.right!=null)
                controlledDFS(temp.right);
            
            return temp.val;
    }
    
    public boolean hasNext() {
        
        return !stack.isEmpty();
    }
}
