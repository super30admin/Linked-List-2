//time complexity: O(n)
//space complexity: O(n)

//where n is the number of elements in tree

import java.util.*;
class BSTIterator {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    List<Integer> list;
    Iterator<Integer> itr;

    public BSTIterator(TreeNode root) {
        list=new ArrayList<>();
        inOrder(root);
        itr = list.iterator();
        
    }
    
    /** @return the next smallest number */
    public int next() {
        return itr.next();
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(itr == null)
            return false;
        return itr.hasNext();
    }
    
    public void inOrder(TreeNode root)
    {
        if(root==null)
            return;
        
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */