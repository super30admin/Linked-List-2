// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.List;

public class BSTIterator {
    List<Integer> inorderList;

    int index = -1;

    private void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        inorderList.add(root.val);
        inorder(root.right);
    }

    public BSTIterator(TreeNode root) {
        inorderList = new ArrayList<Integer>();
        inorder(root);
        index = 0;
    }

    /** @return the next smallest number */
    public int next() {
        int ret = inorderList.get(index);
        index++;
        return ret;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(index > inorderList.size() - 1){
            return false;
        } else {
            return true;
        }
    }
}
