import java.util.Stack;

//T.C- O(1)- average, cause we are not always pushing, for pushing O(N), for popingO(N) so O(1) 
//S.C- O(h)- to store all elements in the stack


//   Definition for a binary tree node.
  public class bstiterator {
      int val;
      bstiterator left;
      bstiterator right;
      bstiterator() {}
      bstiterator(int val) { this.val = val; }
      bstiterator(int val, bstiterator left, bstiterator right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }
 

class BSTIterator {
    private Stack<bstiterator> stack= new Stack<>();
    public BSTIterator(bstiterator root) {
        bstiterator node= root;
        updatestack(node);
    }
    
    public int next() {
        bstiterator removed= stack.pop();
        updatestack(removed.right);
        return removed.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    private void updatestack(bstiterator node){
        while(node!=null){
            stack.push(node);
            node=node.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */