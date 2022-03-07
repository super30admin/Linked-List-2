/ /Time Complexity : o(n) n = number of nodes
// Space Complexity :  o(n) n = number of nodes
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
//Approach : Iterative approach where we maintain ou own stack, initialise the stack with all the leftmost element
// whenever , next() is called, pop() the element and add the right and all the element left of the right.

class BSTIterator {

    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        explore(root);
    }


    private void explore(TreeNode node)
    {
        while(node!=null)
        {
            stack.push(node);
            node= node.left;
        }
    }

    public int next() {
        TreeNode node = stack.pop();
        //node's left child is processed
        //LNR -> PROCESSED L, Make sure to process right children

        explore(node.right);
        return node.val;



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