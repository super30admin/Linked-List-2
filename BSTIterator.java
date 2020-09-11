// Time Complexity : next and hasNext: O(1) 
// Space Complexity : O(h)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// Using a queue and inorder to populate the queue when initialize
class BSTIterator {
    
    Queue<TreeNode> queue;

    public BSTIterator(TreeNode root) {
        queue = new LinkedList<>();
        inorder(root, queue);
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode curr = queue.poll();
        return curr.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return queue.size() > 0;
    }
    
    private void inorder(TreeNode root, Queue<TreeNode> queue) {
        if(root==null)
            return;
        
        inorder(root.left, queue);
        queue.add(root);
        inorder(root.right, queue);
    }
}
