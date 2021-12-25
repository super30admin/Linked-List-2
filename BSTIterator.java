// Time Complexity
// Constructor intialize elements O(h) which we do not consider in calculation
// next() T: O(1) amortized worst case T: O(h) where h is height of tree
// Space Complexity : O(h)
// We need inorder traversal with controlled recursion
public class BSTIterator {
    Stack<TreeNode> s;
    public BSTIterator(TreeNode root) {
        s = new Stack<>();
        inOrderTraversal(root);
    }
    
    public int next() {
        TreeNode curr = s.pop();
        inOrderTraversal(curr.right); // check the right branch for inorder traversal
        return curr.val;
    }
    
    public boolean hasNext() {
        return !s.isEmpty();
    }
    
    
    private void inOrderTraversal(TreeNode root)
    {
        // push root and its non null left child
        while(root != null)
        {
            s.push(root);
            root = root.left;
        }
    }
}