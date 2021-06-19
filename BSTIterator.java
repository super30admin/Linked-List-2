/*SC  - O(N), TC -O(N) 
 * Create an inorder of the list in the first place and use an index to keep track of the next elements in order
 * */


class BSTIterator {

    List<Integer> res ;
    int index;
    public void  inorder( TreeNode root){
        if (root == null){
            return;
        }
        this.inorder(root.left);
        this.res.add(root.val);
        this.inorder(root.right);
    }
    public BSTIterator(TreeNode root) {

         res = new ArrayList<Integer>();
         this.index = -1;
         this.inorder(root);
    }
    public int next() {
      this.index +=1;
        return this.res.get(this.index);
    }

    public boolean hasNext() {
        //[1,2,3,4,5]
        // 5-->  (res.size-1)
        //index should be less than (res.size-1)
        return this.index < this.res.size()-1;
    }
}
