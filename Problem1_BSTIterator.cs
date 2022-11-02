// Approach : Do iterative inorder traversal. Maintain the stack such that it always has the next smallest number in the tree. For this when initializing push to stack, until you reach the left most leaf node. When next is called you pop from the stack to get the next number in the iteration. A node is popped from stack, means we have already processed the left subtree of the node. Now we have to process the right subtree(push nodes from the right subtree) to get the next node in the sequence.
// Amortized Time Complexity: O(1). To get a next node sometimes we push upto (h) nodes into stack. But once we push those many nodes, we can directly read them from the stack in one step.
// Space Complexity: O(h), where h is the height of the tree. The stack can grow upto to height of the tree. In worst when the tree is skewed it can go upto O(n) and best case when tree is balanced it would be O(log n)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class BSTIterator {
    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        st = new Stack<TreeNode>();
        iter(root);
    }
    
    private void iter(TreeNode node){
        while(node != null){
            st.Push(node);
            node = node.left;
        }
    }
    
    public int Next() {
        var next = st.Pop();
        iter(next.right);
        return next.val;
    }
    
    public bool HasNext() {
        return st.Count != 0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.Next();
 * bool param_2 = obj.HasNext();
 */