// Time Complexity : O(1) average, O(h) worst, where h = height of the tree
// Space Complexity : O(h), where h = height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
APPROACH 1: (Taking an array List)
Store the inorder traversal in an array list and iterate through the list as usual.

APPROACH 2: (Using stack)
DFS - traversing to the left child of the root till we hit null.
When moving to child, parent is pushed into the stack.
Once Next is called, the topmost element is popped and again DFS is called onto the right child of the node.
 */

public class BSTIterator{

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

    private void dfs(TreeNode root){
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode result = stack.pop();
        dfs(result.right); //call on right side once element is popped out
        return result.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

// Taking an array list but is an incorrect solution
/*

class BSTIterator {
    Queue<TreeNode> queue;

    public BSTIterator(TreeNode root) {
        queue = new LinkedList<>();
        inorder(root);
    }

    private void inorder(TreeNode root){
        //base
        if(root == null) return;

        //logic
        inorder(root.left);
        queue.add(root);
        inorder(root.right);

    }

    public int next() {
        if(!queue.isEmpty()){
            return queue.poll().val;
        }
        return -1;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
*/