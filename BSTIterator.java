import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }


public class BSTIterator {// Iterator should be lazy and it should be ThreadSafe
//    **********************This is not the Approach*********************
    List<TreeNode> li;
    int i;
//    public BSTIterator(TreeNode root) {
//        this.li = new ArrayList<>();
//        this.i = 0;
//        inorder(root);
//
//    }
    private void inorder(TreeNode root){
        //base
        if(root == null) return;
        inorder(root.left);
        li.add(root);
        inorder(root.right);
    }

    public int next() {
        TreeNode temp = li.get(i);
        i++;
        return temp.val;
    }

    public boolean hasNext() {
        return i < li.size();
    }

    // TC:O(h) worst case for best case O(1)
    // SC:O()
    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        this.st = new Stack<>();
        init(root);
    }
    private void init(TreeNode root){
        while(root!=null){
            st.push(root);
            root = root.left;
        }
    }

    public int next1() {
        TreeNode temp = st.pop();
        if(temp.right != null){
            init(temp.right);
        }
        return temp.val;
    }

    public boolean hasNext1() {
        return !st.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
