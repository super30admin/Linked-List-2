// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class BSTIterator {

    private Stack<TreeNode> s = new Stack<TreeNode>();

    public BSTIterator(TreeNode root) {
        // We put only left eleemnts in stack
        // Because we should not process all elements until its needed. we can put left tree as we call next() method, if it exists
        if(root != null)
            DFS(root);
    }

    public int Next() {
        
        if(!HasNext())
            return Int32.MinValue;
        
        //we pop the element return it
        var node = s.Pop();
        // Also we check if that popped element has right child
	    // Yes, then call DFS, traverse all the way to left node and put all nodes in stack
        if(node.right != null)
            DFS(node.right);
        
        return node.val;
    }
    
    //stack not empty, return true, else return false
    public bool HasNext() {
        return s.Count != 0;
    }
    
    private void DFS(TreeNode node)
    {
        while(node != null)
        {
            s.Push(node);
            node = node.left;
        }
    }

}