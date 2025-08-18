// Time Complexity : next(): Amortized O(1); overall O(n) across all calls; hasNext(): O(1)
// Space Complexity : O(h) — stack holds the path from root to current (h = tree height)
// Did this code successfully run on LeetCode : Yes (class name must be BSTIterator on LC)

// approach:
// 1) Maintain a stack of the left spine from current node.
// 2) next(): pop top, then push the left spine of its right child.
// 3) hasNext(): true if stack not empty.


import java.util.Stack;

public class BSTIteratorCode {
    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        this.st = new Stack<>();
        dfs(root);
    }

    private void dfs(TreeNode root){
        while(root != null){
            st.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode temp = st.pop();
        dfs(temp.right);
        return temp.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}
