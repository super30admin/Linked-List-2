// Time Complexity : Amortized O(1) [50% are leaves and they take O(1) time]
// Space Complexity : Amortized O(1) [O(h) for stack but is the tree is right skewed its O(1)] 
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// All iterators should implement lazy loading. We push all the left elements to the stack and when any element is popped, we check for the right child. And the left tree of the right child is pushed to the stack.

class BSTIterator {

    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        this.st = new Stack();
        dfs(root);        
    }

    private void dfs(TreeNode root){
        while(root != null){
            st.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode top = st.pop();
        dfs(top.right);
        return top.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}