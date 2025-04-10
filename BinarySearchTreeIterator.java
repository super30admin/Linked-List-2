
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

class BinarySearchIterator {
    List<Integer> myList;
    int idx;
    public BSTIterator(TreeNode root) {
        //Base Case
        this.myList = new ArrayList<>();
        this.idx = 0;
        //
        helper(root, myList);
    }

    private void helper(TreeNode root, List<Integer> myList){
        if(root == null)
            return;
        helper(root.left, myList);
        myList.add(root.val);
        helper(root.right, myList);
    }
    
    public int next() {
        return myList.get(idx++);
    }
    
    public boolean hasNext() {
        if(idx>=myList.size())
            return false;
        return true;
    }
}
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */


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
class BinarySearchTreeIterator {
    Stack<TreeNode> myStack;
    public BSTIterator(TreeNode root) {
        this.myStack = new Stack();
        helper(root);
    }

    private void helper(TreeNode root){
        if(root == null)
            return;
        myStack.push(root);
        helper(root.left);
    }
    
    public int next() {
         TreeNode temp = myStack.pop();
         helper(temp.right);
        return temp.val;
    }
    
    public boolean hasNext() {
        return !myStack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */