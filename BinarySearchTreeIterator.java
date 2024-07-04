/**
    Approach: Tree traversal DFS

    Working:
        Declarer a stack
        initially dfs and push all left node values to the stack

        next():
            pop from stack
            dfs node.right to add if there ara any left nodes
            return node.val
        hasNext()
            check if stack is empty and return

    Time Complexity: O(h) amortized O(1)
    Space Complexity: O(h)

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
class BinarySearchTreeIterator {

    Stack<TreeNode> s;
    public BSTIterator(TreeNode root) {

        s= new Stack<>();
        dfs(root);
    }

    public int next() {

        TreeNode node = s.pop();
        dfs(node.right);
        return node.val;
    }

    public boolean hasNext() {

        return !s.isEmpty();
    }

    private void dfs(TreeNode root) {

        while(root != null) {
            s.push(root);
            root = root.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */