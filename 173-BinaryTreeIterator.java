//Approach-1: Using the array 
class BSTIterator {
    ArrayList<Integer> data;
    int indx;
    
    public BSTIterator(TreeNode root) {
        indx = 0;
        data = new ArrayList<Integer>();
        helper(root);
    }
    
    private void helper(TreeNode node){
        if(node == null) return;
        
        helper(node.left);
        data.add(node.val);
        helper(node.right);
        
        return;
    }
    
    //Time Complexity: O(1)
    public int next() {
        int val = 0;
        if(indx < data.size()){
            val = data.get(indx);
            indx++;
        }
        return val;
    }
    
    //Time Complexity:O(1)
    public boolean hasNext() {
        return indx < data.size();
    }
}



//Approach-2: Using over-the-hood stack approach - Iterative Preorder approach
class BSTIterator {
    Stack<TreeNode> st; 
    
    public BSTIterator(TreeNode root) {
        st = new Stack<TreeNode>();
        helper(root);
    }
    
    public void helper(TreeNode node){
        while(node != null){
            st.push(node);
            node = node.left;
        }
        
        return;
    }
    
    //Time Complexity: O(1) -> Average
    //Time Complexity: O(H) -> Worst Case
    public int next() {
        int val = -1;
        if(!st.isEmpty()){
            TreeNode temp = st.pop();
            val = temp.val;
            helper(temp.right);
        }
        return val;
    }
    
    //Time Complexity: O(1) 
    public boolean hasNext() {
        return !st.isEmpty();
    }
}