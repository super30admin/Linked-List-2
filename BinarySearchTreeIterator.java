/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

//TIme Complexity=O(n)//n is depth of tree
//Space complexity=O(n)

class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack=new Stack();
        DFS(root);
    }
    
    /** @return the next smallest number */
    public int next() {        
        TreeNode node=stack.pop();
        if(node.right!=null)
        {
            DFS(node.right);
        }
        return node.val;
  }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(!stack.isEmpty())
        {
            return true;
        }
        return false;
    }
    public void DFS(TreeNode root)
    {
        while(root!=null)
        {
            stack.push(root);
            root=root.left;
        }
            
    }
}


/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */