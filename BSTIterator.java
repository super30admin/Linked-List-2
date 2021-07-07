// 173.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//brute force - do inorder traversal ans store in list, have a cursor to iterate to get time O(n) and space O(n)

//approach - a native iteartor shouldnot alter the data structure
//initially do a pushLeft(root) which pushes all nodes in the leftmost path and min is in top
//next() - pop from stack and do pushLeft(popped element's right child) to update stack top with next min
//hasnext() - if stack has more elements return true else false

//time - O(h) on average is constant
//space - O(h) on average is constant

class BSTIterator {
    Stack<TreeNode> support;
    
    public BSTIterator(TreeNode root) {
        support = new Stack<>();
        pushLeft(root);
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode current = support.pop();
        pushLeft(current.right);
        return current.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (support.size() > 0);
    }
    
    //keeps on pushing root and its left descendants till root is null
    private void pushLeft(TreeNode root) {
        while(root != null)
        {
            support.push(root);
            root = root.left;
        }
        return;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
