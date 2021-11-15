TIME COMPLEXITY: O(1)
SPACE COMPLEXITY: O(h), only pushing elements of either left or right side
running on leetcode: yes
*/
class BSTIterator {
    Stack<TreeNode> s;
    public BSTIterator(TreeNode root) {
        s = new Stack<>();
        dfs(root);
    }
    
    public int next() {
        //pop, check for right and ret value
        TreeNode popped=s.pop();
        dfs(popped.right);
        return popped.val;
    }
    
    public boolean hasNext() {
        //check if the stack is empty, if stack is not empty , there is element present in the tree
        return !s.isEmpty();
    }
    //traverse the tree and push only root and left elements in the stack
    private void dfs(TreeNode root)
    {
        while (root != null)
        {
            s.push(root);
            root=root.left;
        }
    }
}
