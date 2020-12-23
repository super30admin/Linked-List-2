// Time Complexity :O(1) and O(N) in worst case
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    Stack<TreeNode> s;
    public BSTIterator(TreeNode root) {
        this.s = new Stack<>();
       
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

/**
* Your BSTIterator object will be instantiated and called as such:
* BSTIterator obj = new BSTIterator(root);
* int param_1 = obj.next();
* boolean param_2 = obj.hasNext();
*/