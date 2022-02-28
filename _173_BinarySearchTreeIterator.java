// Time Complexity : o(n) n = number of nodes
// Space Complexity :  o(n) n = number of nodes
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
//Approach : Iterative approach where we maintain ou own stack, initialise the stack with all the leftmost element
          // whenever , next() is called, pop() the element and add the right and all the element left of the right.
class BSTIterator {

    Stack<TreeNode> s;

    public BSTIterator(TreeNode root) {
        s = new Stack<>();
        TreeNode curr = root;
        while(curr != null){
            s.push(curr);
            curr = curr.left;
        }
    }

    public int next() {
        TreeNode val = s.pop();
        TreeNode curr = val;

        curr = curr.right;

        while(curr != null){
            s.push(curr);
            curr = curr.left;
        }
        return val.val;
    }

    public boolean hasNext() {
        return !s.isEmpty();
    }
}
