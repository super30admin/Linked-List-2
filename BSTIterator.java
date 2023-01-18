// Time Complexity : ammortized O(1)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//in this approach we recurse on the root in inorder manner. for the next we pop the next and return val
//if the size of the list is greater than 0 then we will have next node so that will return true or false accordingly.
class BSTIterator {
    private LinkedList<TreeNode> li;
    public BSTIterator(TreeNode root) {
        li= new LinkedList();
        inorder(root);
    }
    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        li.add(root);
        inorder(root.right);
    }
    public int next() {
        TreeNode re = li.poll();
        return re.val;
    }
    
    public boolean hasNext() {
        if(li.size()>0)return true;
        return false;
    }
}


//not accepted
class BSTIterator {
    private LinkedList<TreeNode> li;
    public BSTIterator(TreeNode root) {
        li= new LinkedList();
        inorder(root);
    }
    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        li.add(root);
        inorder(root.right);
    }
    public int next() {
        TreeNode re = li.poll();
        return re.val;
    }
    
    public boolean hasNext() {
        if(li.size()>0)return true;
        return false;
    }
}