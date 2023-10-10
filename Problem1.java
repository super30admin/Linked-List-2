// Time Complexity : O(1) s.pop() operation takes O(1) time
// Space Complexity : O(h) where h is the height of tree and stack will store all left nodes of tree = height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem1 {
    Stack<TreeNode> s;

    public BSTIterator(TreeNode root) {
        s = new Stack<>();
        dfs(root);
    }

    public int next() {
        TreeNode next = s.pop();
        dfs(next.right);
        return next.val;
    }

    public boolean hasNext() {
        if(s.isEmpty()){
            return false;
        }
        return true;
    }

    private void dfs(TreeNode root){
        while(root != null){
            s.push(root);
            root = root.left;
        }
    }
}
