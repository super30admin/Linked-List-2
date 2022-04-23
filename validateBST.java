//Time Complexity : O(n)
//Space Complexity : O(h)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Solution {
    public boolean isValidBST(TreeNode root) {
        //base case
        if(root==null)
            return true;
        
        //inorder traversal
        //to iterate over inorder traversal, use stack with return type TreeNode
        Stack<TreeNode> s=new Stack<>();
        //iterative implementation
        TreeNode previous=null;
        //when root and tree is not empty
        while(root!=null || !s.isEmpty()){
            while(root!=null){
                s.push(root);
                root=root.left;
            }
            root=s.pop();
            if(previous!=null && previous.val>= root.val)    
                return false;
            previous=root;
            root=root.right;            
        } 
        return true;
    }
}