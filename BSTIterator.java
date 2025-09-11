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
//TC: Amortized O(1) -> for leaf node, it will be O(1) -> there will be n/2 leaf node so 50% of the processing with O(1), one level above the leaf node is also 0(1)
//SC: O(h) -> extra stack space to process node at most it will be the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
* Iterator: They are lazy loaders. They will only worry about the current patch and the next patch thats going to be processed. So if the data apart from the current and next are being changed the iterator will take care of it when it will process that
* So if you try to add all the tree nodes in the arraylist, if there is any change in the tree structure, then the change will not reflected in the arraylist as that will be created only once during the start of the program
* Hence, we need to come up with lazy evaluation technique. We use stack to keep track of the nodes visited and we only add nodes as and when required so we are not using extra space up front
*/
class BSTIterator {
    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        this.st = new Stack<>();
        dfs(root);
        
    }

    private void dfs(TreeNode root){
        while(root != null){
            st.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        int smallestElement = -1;
        if(hasNext()){
            TreeNode temp = st.pop();
            smallestElement = temp.val;
            dfs(temp.right);
        }
        return smallestElement;
    }
    
    public boolean hasNext() {
        if(st.size() != 0)
            return true;
        return false;
        
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
