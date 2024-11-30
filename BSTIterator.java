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


// Time Complexity : 0(1) Ammortized T.C.
// Space Complexity : 0(h) - Height Od the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach:
class BSTIterator {
    Stack <TreeNode> s = new Stack<>();     //declaring a stack to run dfs

    public BSTIterator(TreeNode root) {
        s = new Stack<>();      //Initializing the stack
        dfs(root);      //passing the root to the dfs function
    }

    public int next() {
        TreeNode top = s.pop();     //poppin the top element when next() function is called and cehcking if it has a right subchild or not
        dfs(top.right);             //If it has a right subchild, then going to the left most element of the right subchild if it has 1
        return top.val;         //returning the top of the element
    }

    public boolean hasNext() {
        return !s.isEmpty();
    }

    public void dfs(TreeNode root){
        while(root != null){        //navigating to the left most element of the tree and storing the path in the stack
            s.push(root);
            root = root.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */