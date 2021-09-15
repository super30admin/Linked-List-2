

import java.util.*;
public class BSTIterator {
    static Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack<>();     
        dfs(root);   
    }
    //time complexity : H
    // space complexity : H
    public int next() {
       TreeNode temp = st.pop();
        dfs(temp.right);
        return temp.val;
    }
    //time complexity : 1
    // space complexity : 1
    public boolean hasNext() {
        return !st.isEmpty();
    }
    
    private static void dfs(TreeNode root){
       while(root != null){
            st.push(root);
            root= root.left;
       }

    }
}
