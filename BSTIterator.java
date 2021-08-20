/**
 * Definition for a binary tree node.
 */ 


// Time Complexity : O(1)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes, with optimized approach


// Your code here along with comments explaining your approach
/*Approach
1)the approach is to have O(1) time and O(h) space, thus we use controlled recrusion and not accessing all elements at once.
2) for this, we just carry out dfs and just put left elements in stack (inorder traversal). We do not consider right side.
3) thus with every next call() to iterator, we pop the most recent element and then check if the treenode has right elements.
4) if it has then we again push all left children of the right child of the popped element
5) 2
    \
     6
     /
    4
   /
  3
6) this would work when we pop 5 then we check if right exists for 2, if yes, we push all left side of 6 ->(4 and 3 in stack)
7) again wait for the next call and pop elements
*/


import java.util.*; 
class BSTIterator {

    public class TreeNode {
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


    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        
        stack = new Stack<>();
        dfs(root);
        
    }
    
    public int next() {
        
        TreeNode node = stack.pop();
        dfs(node.right);
        return node.val;
        
    }
    
    public boolean hasNext() {
        
        return !stack.isEmpty();
    }
    
    // controlled recursion to achieve O(h) space complexity
    // we just put the left elements at first and not right;
    public void dfs(TreeNode root)
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