/*
class BSTIterator:

    def __init__(self, root: TreeNode):
        self.stack = []
        self.dfs(root)

    def next(self) -> int:
        if len(self.stack) == 0:
            return -1
        popped = self.stack.pop()
        self.dfs(popped.right)
        
        return popped.val
        

    def hasNext(self) -> bool:
        if len(self.stack) == 0:
            return False
        return True
    

    def dfs(self, root):
        if root is None:
            return
        while root is not None:
            self.stack.append(root)
            root = root.left
*/

// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class BSTIterator {
    Stack<TreeNode> s;
    public BSTIterator(TreeNode root) {
        s = new Stack<>();
        dfs(root);
    }
    
    public int next() {
        if (s.size() == 0)
            return  -1;
        
        TreeNode popped = s.pop();
        dfs(popped.right);
        return popped.val;
    }
    
    public boolean hasNext() {
        return !s.isEmpty();
    }
    
    private void dfs(TreeNode root){
        if (root == null)
            return;
        
        while (root != null){
            s.push(root);
            root = root.left;
        }
    }
}
