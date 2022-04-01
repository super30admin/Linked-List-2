// Time Complexity : O(1) average, O(h) worst case
// Space Complexity : O(h) stack space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

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
class BSTIterator {

    //use controlled recursion - iterative verison for recursive function

    //stack to imitate recursion
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {

        stack = new Stack();

        //we divide recursion of tree into two parts - left and right

        //left recursive call
        dfs(root);
    }

    public void dfs(TreeNode root)
    {
        while(root != null)
        {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {

        //top of stack will always have the node that next() has to return
        TreeNode result = stack.pop();

        //make sure, before we return the val, next valid element is at top
        //right recursive call
        //this is made only when next() is called again and we have popped the top
        //in uncontrolled recusrion, both left and right recursive calls happend without us interrupting
        //we are letting user mess with the right vals as much as he wants untill next() reaches there, thus making our iterator dynamic
        dfs(result.right);

        return result.val;

    }

    public boolean hasNext() {
        //will return false only when stack is empty;

        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
