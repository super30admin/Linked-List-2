time complexity: O(1)
space complexity: O(h)

class BSTIterator {
    
    Queue<TreeNode> q=new LinkedList<>();

    public BSTIterator(TreeNode root) {
        dfs(root);
        
		}
    
    void dfs(TreeNode root){
        if(root==null) return;
        dfs(root.left);
        q.add(root);
        dfs(root.right);
    }
    
    public int next() {
        return q.poll().val;
    }
    
    public boolean hasNext() {
        return q.size()!=0;
    }
}