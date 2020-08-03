import java.util.Stack;

class BSTIterator {
	//Approach:
	//1. I have done controlled recursion with the help of a stack to achieve the functionality of next(). So, when next() is called, we need to fetch the min value,
	//2. Am trying to do inorder traversal but recursion will happen only for inserting left nodes onto the stack. So whenever a node is passed for dfs, 
	//it just traverses all the way to left inserting nodes on the way. 
	//3. dfs function is called initially and then when next() is called everytime, a node is popped from the stack and we do traversal of right branch during it.
	//4. For hasNext() - we are checking whether stack isempty().
	
	Stack<TreeNode> stack;
    
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        dfs(root);
    }
    
    /** @return the next smallest number */
    public int next() {
        
        TreeNode node = null;
        if(!stack.isEmpty())
        {
            node = stack.pop();
            dfs(node.right);
        }        
        return node.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    public void dfs(TreeNode root)
    {
        if(root == null)
            return;
        while(root != null)
        {
            stack.push(root);
            root = root.left;
        }
    }
}
//Time Complexity : O(1) amortized time complexity for next() function, since we will be traversing only right nodes. 
//Space Complexity : O(h) where h is the height of the tree.
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :

class TreeNode {
    int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}
/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */