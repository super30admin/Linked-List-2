/**
Leetcode : https://leetcode.com/problems/binary-search-tree-iterator/
173. Binary Search Tree Iterator

Implement the BSTIterator class that represents an iterator 
over the in-order traversal of a binary search tree (BST):

Collabedit: http://collabedit.com/wh2mq

Time Complexity : O(N)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

**/

class BSTIterator 
{
    
    Stack<TreeNode> stack;
    
    public BSTIterator(TreeNode root) 
    {
        this.stack = new Stack<>();
        depthFirstSearch(root);
    }
    
    public int next() 
    {
        TreeNode current = this.stack.pop();
        depthFirstSearch(current.right);
        
        return current.val;
    }
    
    public boolean hasNext() 
    {
        return !this.stack.isEmpty();
    }
    
    private void depthFirstSearch(TreeNode root)
    {
        while(root!=null)
        {
            this.stack.push(root);
            root = root.left;
        }
    
    }
}





