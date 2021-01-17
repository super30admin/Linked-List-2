// Time Complexity : 0(n)
// Space Complexity : 0(h) because at a given time space of stack would be h(height of BST)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class BSTIterator {

    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        dfs(root); //going till leaf node so that we get 1st element of inorder
    }

    public int next() {
        TreeNode result = stack.pop();
        dfs(result.right); //controlling recurssion
        //we will do inorder traversal further only after returning this element
        return result.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public void dfs(TreeNode root){
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }
}