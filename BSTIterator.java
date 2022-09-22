// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No.
// Your code here along with comments explaining your approach
/*
Perform Morris traversal
* */
public class BSTIterator {
    TreeNode curr=null;
    public BSTIterator(TreeNode root) {
        curr=root;
    }

    private TreeNode morrisTraversal(){
        TreeNode result=null;
        while(this.curr!=null){
            TreeNode leftNode=this.curr.left;
            if(leftNode==null){
                result=this.curr;
                this.curr=this.curr.right;
                break;
            }else{
                TreeNode rightMostNode=getRightMostNode(leftNode);
                if(rightMostNode.right==null){
                    rightMostNode.right=this.curr;
                    this.curr=this.curr.left;
                }else{
                    result=this.curr;
                    rightMostNode.right=null;
                    this.curr=this.curr.right;
                    break;
                }
            }
        }
        return result;
    }

    private TreeNode getRightMostNode(TreeNode rmn){
        while(rmn.right!=null && rmn.right!=this.curr)
            rmn=rmn.right;

        return rmn;
    }

    public int next() {
        // if(!hasNext()) return -1;
        TreeNode result=morrisTraversal();
        return result.val;
    }

    public boolean hasNext() {
        return this.curr!=null;
    }
}

