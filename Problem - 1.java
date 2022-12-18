// Time Complexity : O(1), ammortized time, as for some nodes needs to be traversed deep which happens only some time
// Space Complexity : O(h), the stack would hold at max elements of h where h is the height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : coming up with the DFS logic was hard


// Your code here along with comments explaining your approach

class BSTIterator {

    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        DFS(root); // push the root, this would make the left subtree inside the stack
    }
    //should return the node's value on top of the stack and do dfs on the right
    // O(1) amortized time, once we have hit the h of the subtree from there next would operate on O(1) time
    // 75 % of the time, the time complexity would be O(1) , for leaves node and 1 level above that , it would be O(1)
    // e.g 2^h leaf nodes for a tree which is 4 levels deep which is alost 75% of the tree
    public int next() {

        TreeNode current = stack.pop();
        int val = current.val;
        // before returning do a dfs on the right subtree
        DFS(current.right);
        return val;
        
    }
    // if there are elements in my stack then hasNext should be true
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    // this function would recurse left and keep elements on the top of the stack
    private void DFS(TreeNode node){
        if(node == null) return;
        stack.push(node);
        DFS(node.left);
    }
}
