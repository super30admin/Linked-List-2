// Time Complexity : O(n)
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Since we have to get the minimum when next is called, we do in-order traversal and put the left most node in the stack since left most will give us the minimum value.
 * When next is called, we check if the stack's top node has right subtree or not. If it has, we add it to the stack since that will have the next smallest number after previous smaller number from left tree was popped from stack.
 */
class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        dfs(root);
    }

    private void dfs(TreeNode curr) {
        while(curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
    }

    public int next() {
        TreeNode result = stack.pop();
        dfs(result.right);
        return result.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */