/*
Approach 
Use a stack to store the path of left nodes, making the smallest available node stay at the top.
next() pops the top node and pushes the left path of its right subtree.
hasNext() simply checks whether the stack is non-empty.

Time Complexity: O(1) average for next(), O(1) for hasNext().
Space Complexity: O(h), where h is the height of the tree.
*/

import java.util.Stack;
class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator (TreeNode root){
        stack = new Stack<>();
        pushLeft(root);
    }

    private void pushLeft(TreeNode node){
        while (node != null){
            stack.push(node);
            node = node.left;
        }
    }

    public int next(){

        //top of the stack is the next smallest vallue
        TreeNode node = stack.pop();

        // Process the right tree 
        pushLeft(node.right);

        return node.val;
    }

    public boolean hasNext(){
        return !stack.isEmpty();
    }

}
