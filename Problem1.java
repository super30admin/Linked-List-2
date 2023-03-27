// TimeComplexity : O(h)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*Controlled recursion using iterator. 
Push the root and run recursion on left child. 
Don't do right recursion untl all left children are complete. 
 * 
 */
public class Problem1 {
    Stack<TreeNode> st ;
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
        TreeNode node = st.pop();
        dfs(node.right);
        return node.val;
    }
    public boolean hasNext() {
        return !st.isEmpty();
    }
}
