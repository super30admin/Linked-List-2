
    /**
    Time Complexity :
    Constructor -> O(H)
    next()      -> Amortized O(1)
    hasNext()   -> O(1)

    Explanation:
    - Constructor pushes all left nodes → O(H)
    - Each node is pushed and popped once → total O(N)
    - So next() is amortized O(1)

    Space Complexity : O(H)
    Explanation:
    Stack stores at most height of the tree (H).

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially thought to store full inorder traversal in a list,
    which uses extra space.
    Optimized it using a stack to simulate inorder traversal lazily.
    Also ensured that after visiting a node, we process its right subtree
    by pushing all its left children.
    */

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


    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        this.st = new Stack<>();
        dfs(root);
    }

    // Push all left nodes
    private void dfs(TreeNode root) {
        while (root != null) {
            st.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode re = st.pop();

        // Process right subtree
        dfs(re.right);

        return re.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */