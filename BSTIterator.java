package linkedList2;

/**
 * 
 * In iterator we try to handle the dynamicity of the parent data structure. Here when a BSTIterator object is initialized with the root of a tree, we create iterate from root to the left child and 
 * then further left in an iterative manner till we reach null and store each node into the stack. When next() is called we pop the stack to return the value and only then process the right subtree for
 * that element hence handling dynamicity.
 * 
 * Time Complexity : 
 * next() : Amortized complexity is O(1) as in majority of the cases at higher levels the right subtree is just one step away from the popped element.
 * hasNext() : O(1) complexity.
 * 
 * Space Complexity : O(1) as the stack created is not in a user oriented function.
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 */
import java.util.Stack;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;    }
 }

public class BSTIterator {
    Stack <TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        dfs(root);
    }

    void dfs(TreeNode node){
        while(node!=null)
        {
            stack.push(node);
            node=node.left;
        }
    }
    
    public int next() {
        if(hasNext()){
            TreeNode popped= stack.pop();
            dfs(popped.right);
            return popped.val;
        }

        return -1;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }

}
