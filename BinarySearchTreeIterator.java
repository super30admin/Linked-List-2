//Time Complexity = O(1) //Amortized
    //n/4 leaf node - O(1), n/2 - right above leaf - O(1) so amortized O(1)

//Space Complexity = O(1)
//Does it run on LeetCode successfully? : Yes
//Any difficulties: It is not straight forward.

/*
Sol-1: 
* Perform Inorder traversal
* Add to List
* next should read from list (maintain marker from where to read)
* if It is out of bound then it throws an error
* if marker is not at out of bound then hasNext always return true

It defeats the purpose of Iterator being lazy loading data structure
It doesn't support dynamic loading
------
Sol-2:
* Control recursion.
* Only do control recursion when needed and next element is being requested

First add all left nodes of tree to stack, stop and wait till pop. Once pop happens then go to its all right node's left elements again ... (not right nodes right nodes)..
*/


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
        st = new Stack<TreeNode>();
        helper(root);
        
    }

    private void helper(TreeNode root){
        while(root!= null){
            st.push(root);
            root = root.left;
        }
    }
    
    //In Data Structure design, we always cares about amortized so O(1)
    //n/4 leaf node - O(1), n/2 - right above leaf - O(1) so amortized O(1)
    public int next() { //O(h) - Height of Tree // h calls in stack
        TreeNode result = st.pop();
        helper(result.right);
        return result.val;
    }
    
    public boolean hasNext() { //O(1)
        return !st.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
