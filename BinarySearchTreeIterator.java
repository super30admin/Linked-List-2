// Time Complexity :
// Space Complexity : O(height of BST)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

public class BinarySearchTreeIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        helper(root);
    }

    public int next() {
        // Time Complexity : O(1)

        if(!hasNext()){
            return -1;
        }
        TreeNode poppedNode = stack.pop();
        helper(poppedNode.right); // mostly this call will have 1 node, on an average from here it will be O(1) time
        return poppedNode.val;
    }

    public boolean hasNext() {
        // Time Complexity : O(1)

        return stack.size() > 0;
    }

    private void helper(TreeNode node) {
        // Time Complexity : O(height of BST)

        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }
}