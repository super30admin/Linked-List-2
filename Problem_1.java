// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//Below is the broot for ve method using the extra space.
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
    int pointer;
    int size;
    int[] arr;

    public BSTIterator(TreeNode root) {
        size=0;
        pointer=0;
        TreeNode node=root;
        arr=new int[getTotalElements(node)];
        node=root;
        inOrderTraversal(node);
        //System.out.println(size);
        //System.out.println(Arrays.toString(arr));
        
    }
    
    public int next() {
        return arr[pointer++];
    }
    
    public boolean hasNext() {
        if(pointer<arr.length){
            return true;
        }else{
            return false;
        }
    }
    
    public int getTotalElements(TreeNode node){
        if(node==null){
            return 0;
        }
        return 1+getTotalElements(node.left)+getTotalElements(node.right);
    }
    public void inOrderTraversal(TreeNode node){
        if(node==null){
            return;
        }
        inOrderTraversal(node.left);
        arr[size++]=node.val;
        inOrderTraversal(node.right);
    }
}

// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//Below is the broot for ve method using the extra space.

//**
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
        st=new Stack<TreeNode>();
        TreeNode temp=root;
        dfs(temp);
        
    }
    
    public int next() {
        TreeNode get=st.pop();
        dfs(get.right);
        return get.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
    public void dfs(TreeNode temp){
        while(temp!=null){
            st.push(temp);
            temp=temp.left;
        }
    }
    
    
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */