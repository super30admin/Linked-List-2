/**
Time Complexity : O(N)
Space Complexity : O(N) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
**/
class BSTIterator 
{
    
    Queue<Integer> queue;

    public BSTIterator(TreeNode root) 
    {
        queue = new LinkedList<>();
        inorder(root);
        
    }
    
    public int next() 
    {
        return queue.poll();
    }
    
    public boolean hasNext() 
    {
        return !queue.isEmpty();
    }
    
    private void inorder(TreeNode root)
    {
        if(root ==null)
            return;
        
        if(root.left != null)
            inorder(root.left);
        
        queue.add(root.val);
        
        if(root.right != null)
            inorder(root.right);
    }
}