// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class BSTIterator {
    //Stack to store nodes
    Stack<TreeNode> bstStack;
    public BSTIterator(TreeNode root) {
        bstStack = new Stack<TreeNode>(); //Initialize stack
        //Push all the left most children of the root into stack
        while(root != null) {
            bstStack.Push(root);
            root = root.left;
        }
    }
    
    public int Next() {
        //Pop next node and return its value
        TreeNode curr = bstStack.Pop();
        int res = curr.val;
        //Before returning, move current node to its right child 
        //and push all of its left most children into stack.
        curr = curr.right;
        while(curr != null) {
            bstStack.Push(curr);
            curr = curr.left;
           }
        return res;
    }
    
    public bool HasNext() {
        return bstStack.Count > 0; //if stack is not empty
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.Next();
 * bool param_2 = obj.HasNext();
 */