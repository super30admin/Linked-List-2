import java.util.Stack;
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
1. In a BST the only way we can get a the smallest number everytime is by performing a InOrder traversal. 
2. To perform InOrder traversal using controlled recursion we take a stack datastructure and keep adding all the left node's to the stack till we hit a null
3. everytime we perform a next operation(getting the smallest value present in the tree) we pop the node and check left node's in root=root.right
*/
public class BSTIterator{

    Stack<TreeNode> stack;
    
    public BSTIterator(TreeNode root) {
        stack=new Stack<>();
        dfs(root);
    }
    
    public int next() {
        TreeNode node=stack.pop();
        dfs(node.right);
        return node.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    public void dfs(TreeNode root)
    {
        while(root!=null)
        {
            stack.push(root);
            root=root.left;
            
        }
        
    }
}