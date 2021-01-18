//Time Complexity: O(1) for both hasNext() and next() operations
//Space Complexity: O(h) where h is the height of the tree

//Successfully runs on leetcode: 36 ms

//Approach: We just need to keep a track of only one next node and return it when the next() is called. Hence, we perform dfs
//first on the left subtree and return the first node popped from the stack of left subtree, then we perform dfs on the right
//subtree and return nodes one by one. The hasNext() function just checks if the stack is empty at any point of time



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
    Stack<TreeNode> stack;
public BSTIterator(TreeNode root) {
    stack = new Stack<>();
    dfs(root);
}

public int next() {
    TreeNode res = stack.pop();
    dfs(res.right);   
    return res.val;
}

public boolean hasNext() {
    return !stack.isEmpty();
}

private void dfs(TreeNode root)
{
    while(root != null)
    {
        stack.push(root);
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