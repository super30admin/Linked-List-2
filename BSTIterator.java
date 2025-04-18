import java.util.Stack;

// Time Complexity : O(1) average time
 // Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


/*
It uses a stack to simulate in-order traversal,
initially pushing all left nodes from the root onto the stack.
When next() is called, it pops the top node, processes its value,
and pushes all left descendants of its right child.
The hasNext() method simply checks if the stack is non-empty.
The solution runs in average O(1) time per operation and uses O(h) space,
where h is the height of the tree.
* */
public class BSTIterator {
    Stack<TreeNode> data;
    public BSTIterator(TreeNode root) {

        data=new Stack<>();
        dfs(root);
    }

    private void dfs(TreeNode root)
    {
        if(root==null)
            return;
        data.push(root);
        dfs(root.left);
    }

    public int next()
    {
        TreeNode val=data.pop();
        dfs(val.right);
        return val.val;
    }

    public boolean hasNext(){
        return !data.isEmpty();
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
