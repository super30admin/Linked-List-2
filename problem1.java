//https://leetcode.com/problems/binary-search-tree-iterator/
// Time Complexity : O(1) amortized
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//lazy loading
//we are just taking care of next node and not the rest of the nodes

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
//not lazy loading
//not actual implementation of iterators 
// class BSTIterator {
//     List<Integer> li;
//     int idx;
//     public BSTIterator(TreeNode root) {
//         this.li=new ArrayList<>();
//         inorder(root);

//     }
//     private void inorder(TreeNode root){
//         //base
//         if(root==null) return;
//         //logic
//         inorder(root.left);
//         li.add(root.val);
//         inorder(root.right);
//     }
//     public int next() {
//         int result= li.get(idx);
//         idx++;
//         return result;
//     }
    
//     public boolean hasNext() {
//         if(idx<li.size()) return true;
//         else return false;
//     }
// }

class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        this.st= new Stack<>();
        dfs(root);
    }
    private void dfs(TreeNode root){
        //base
        while(root!=null){
            st.push(root);
            root=root.left;
        }
    }
    public int next() {
        TreeNode result = st.pop();
        dfs(result.right);
        return result.val;
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