import java.util.Stack;
//Time Complexity :O(1) 
//Space Complexity :O(h)
//Did this code successfully run on Leetcode : YES
//Any problem you faced while coding this : None
public class Solution {
	Stack<TreeNode> s;
    public Solution(TreeNode root) {
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

	

