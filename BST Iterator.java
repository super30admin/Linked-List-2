// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : had to learn it from scratch


// Your code here along with comments explaining your approach

class BSTIterator {

    ArrayList<Integer> nodeSorted;      //create a new arrayList to store the elements in InOrder
    int index;                          // index
    
    public BSTIterator(TreeNode root) {
        this.nodeSorted = new ArrayList<Integer>();  // initialize the array
        this.index = -1;                            // index
        this._inOrder(root);                       // store the elements in inOrder
    }
    
    public void _inOrder(TreeNode root){                 // inOrder traversal of the array
        if(root == null)
            return;
        
        this._inOrder(root.left);
        this.nodeSorted.add(root.val);
        this._inOrder(root.right);
    }
    
    /** @return the next smallest number */
    public int next() {
        return this.nodeSorted.get(++this.index);   // return the next element in the array
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return this.index+1 < this.nodeSorted.size();   // if the index is greater than the array size then return
    }
}