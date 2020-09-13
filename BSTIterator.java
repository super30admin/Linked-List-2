//Time Complexity: O(n)
//Space Complexity: O(n) - max depth of the tree for the stack
//Did it run on leetcode: yes
//Problems faced any: No

import java.util.Stack;

class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        dfs(root);
    }

    //This function will push all the elements of tree until left most
    private void dfs(TreeNode root){
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        //The top element will be the smallest element
        TreeNode nextSmall = stack.pop();
        //If the popped node has right subtree will call dfs to push those nodes into stack
        if(nextSmall.right!=null){
            dfs(nextSmall.right);
        }

        return nextSmall.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        //will check if stack is empty or not
        return !stack.isEmpty();
    }
}
