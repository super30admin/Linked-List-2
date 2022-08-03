//Time Complexity- next : O(1) average; hasNext : O(1) 
//Space Complexity: O(h), where h is the height of the tree.
//Code run successfully on LeetCode.

public class Problem1 {

	Stack<TreeNode> s = new Stack<>();

    public BSTIterator(TreeNode root) {
        
        if(root == null)
            return;
        
        dfs(root);
    }
    
    public int next() {
        
        TreeNode curr = s.pop();
        dfs(curr.right);
        return curr.val;
        
    }
    
    public boolean hasNext() {
        
        if(!s.isEmpty())
            return true;
        
        return false;
    }
    
    private void dfs(TreeNode root){
        
        while(root != null){
            
            s.push(root);
            root = root.left;
        }
    }
}
