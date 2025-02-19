//TC: O(n)
//SC: O(1)
//Did it run on leetcode: Yes
public class Solution_BSTIterator {

    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        dfs(root);
    }

    public void dfs(TreeNode root){
        // if(root == null)
        //     return;
        // stack.push(root);
        // dfs(root.left);
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode curr = stack.pop();
        dfs(curr.right);
        return curr.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

}
