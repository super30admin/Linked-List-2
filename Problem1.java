// Time Complexity : O(n)
// Space Complexity : O(n)
    // n is the number of nodes present in the linked list.

// Your code here along with comments explaining your approach
    //We use a method called "Controlled Recursion". We use a stack to store the treeNodes. We will simulate Inorder Traversal.
    //We first move to the left most node in the sub tree while putting the nodes in to the stack. When "next()" method is called, we will return the node value that is on top of the stack.
    //We then move to the right sub tree of the node popped. We then move to the left most node while putting the nodes we came across in to the stack. When "hasNext()" is called, we return false if stack is empty, otherwise we will return true.
    
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

    Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        this.stack = new LinkedList<>();
        TreeNode curr = root;
        while(curr!=null)
        {
            stack.push(curr);
            curr = curr.left;
        }
    }
    
    public int next() {
        TreeNode curr = stack.pop();
        int ans = curr.val;
        curr = curr.right;
        while(curr!=null)
        {
            stack.push(curr);
            curr = curr.left;
        }
        return ans;
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