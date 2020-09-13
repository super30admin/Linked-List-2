Time Complexity:

Constructor : O(h)
next() : O(1)

Space Complexity: O(h)
Ran successfully on leetcode?: yes

class BSTIterator {

    List<TreeNode> list;
    TreeNode rootNode;
    
    public BSTIterator(TreeNode root) {
        list = new ArrayList<TreeNode>();
        helper(root);
        rootNode = root;
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode node = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        if(node.right != null){
            helper(node.right);
        }
        return node.val;
        
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !(list.isEmpty());
    }
    
    private void helper(TreeNode root){
        if(root == null) return;
        list.add(root);
        helper(root.left);
    }
}
