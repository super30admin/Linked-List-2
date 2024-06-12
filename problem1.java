import java.util.Stack;


class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }
class BSTIterator {
    Stack<TreeNode> s;
    public BSTIterator(TreeNode root) {
        s = new Stack<>();
        dfs(root);
    }
    
    public int next() {
        TreeNode result = s.pop();
        dfs(result.right);
        return result.val;
    }
    
    public boolean hasNext() {
        return !s.isEmpty();
    }
    
    private void dfs(TreeNode root){
        while(root != null){
            s.push(root);
            root = root.left;
        }
    }
}

//time complexity O(1)
//space complexity O(h)