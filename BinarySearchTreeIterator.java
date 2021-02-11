// Time Complexity :O(1) average time for hasNext and next functions
// Space Complexity :O(H) where h is the height of the tree 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No.

class BSTIterator {
    Stack<TreeNode> s;
    public BSTIterator(TreeNode root) {
        this.s = new Stack<>();
        //s.push(root);
        while(root!=null){
            this.s.push(root);
            root=root.left;
        }
    }

    public int next() {
        TreeNode top = this.s.pop();
        if(top.right!=null){
            TreeNode r = top.right;
            while(r!= null){
                this.s.push(r);
                r= r.left;
            }
        }
        return top.val;
    }

    public boolean hasNext() {
        return this.s.size()>0;
    }
}
