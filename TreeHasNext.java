//Time complexity: O(n)
//Space complexity: O(n)
//Executed on leetcode.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {
    private Stack<TreeNode> stack; 
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        dfs(root);
    }    
    void dfs(TreeNode root)
    {
        if(root!=null)                  //Traversing tree to all the way left and storing each tree to stack. 
            stack.push(root); 			//On 'next' return pop the tree from stack, return root value and if tree has right tree push to stack untill the root.
        else
            return;
        dfs(root.left);
    }
    public int next() {
         
        if(hasNext())
        {
            TreeNode result = stack.pop();
            dfs(result.right);
            return result.val;
        }       
        
        return -1;
    }
    
    public boolean hasNext() {
        
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */