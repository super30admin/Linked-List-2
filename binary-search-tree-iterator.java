// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach:
// i have implemented this just by taking arraylist and traverse the tree by using recursive call then putting the elements into the list by using index values i am able to get nexta nd hasnext

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
    List<Integer> result;
    int index;
    public BSTIterator(TreeNode root) {//O(1)
         result=new ArrayList<>();
         helper(root);
         
    }
    public void  helper(TreeNode root){ //O(n)
        if(root == null)return;
        helper(root.left);
        result.add(root.val);
        helper(root.right);
    }
    
    public int next() { //O(1)
        
        int re= result.get(index);
        index++;
        return re;
       
    }
    
    public boolean hasNext() { //O(1)
        return index != result.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */


// Time Complexity : O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach: this is iterator approach where it does not pre-evaluate the result it performs lazy loading where i take stack of TreeNode to push into it and until where it root.left reachers null 
//here i just process the left nodes of tree then when i have to pop node then before returning left node i process the right nodes.
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
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
       this.st=new Stack<>();
       helper(root);
    }
    public void helper(TreeNode root){
        while(root != null){
        st.push(root);
        root=root.left;
        }
    }
    public int next() {
        TreeNode res=st.pop();
        helper(res.right);
        return res.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */


