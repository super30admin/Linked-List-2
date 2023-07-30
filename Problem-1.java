// Time Complexity : O(n)
// Space Complexity : O(h) for stack in solution 2(optimal)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


//Solution 1: Bad design using arraylist as everything(full arraylist) is loaded in constructor which would be
//cause of problems incase of multiple user accessing/modifying the tree
// Time: O(n) , Space: O(n) for arraylist + O(h) for stack in recursion = O(n)
class BSTIterator {
    ArrayList<Integer> list;
    int i;
    public BSTIterator(TreeNode root) {
        this.list = new ArrayList<>();
        inorder(root);
    }

    public void inorder(TreeNode root){

        if(root == null) return;

        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
    
    public int next() {
        int result = list.get(i);
        i++;
        return result;
    }
    
    public boolean hasNext() {
        return i!=list.size();
    }
}

//Solution 2: Only left side is pushed onto stack initially , rest is loaded in lazily
//when next() operation is called, an element is poped out and dfs for its right subtree is called and 
//pushed into stack at that point. This way we are never pushing entire tree all at once.
class BSTIterator {
    private Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        this.st = new Stack<>();
        dfs(root);
    }

    private void dfs(TreeNode root){
        while(root!=null){
            st.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode curr = st.pop();
        dfs(curr.right);
        return curr.val;
    }
    
    public boolean hasNext() {
        return (!st.isEmpty());
    }
}