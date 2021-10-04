
//https://leetcode.com/problems/binary-search-tree-iterator/
/*
Time: Next() is Amortized O(1), hasNext() is O(1)
Space: O(h)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

class BSTIterator {
    List<Integer> liist;
    int index;

    public BSTIterator(TreeNode root) {
        liist = new ArrayList<>();
        inorder(root);
    }
    
    public int next() {
        int result = liist.get(index);
        index++;
        return result;
        
    }
    
    public boolean hasNext() {
        return index < liist.size();
    }
    
    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        liist.add(root.val);
        inorder(root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

/* Approach2:

Time: Next() is Amortized O(1), hasNext() is O(1)
Space: O(h)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None

public class BSTIterator {

    Stack<TreeNode> stack = new Stack();

    public BSTIterator(TreeNode root) {
        // partialorder
        partialInOrder(root);

    }

    void partialInOrder(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public int next() {
        TreeNode top = stack.pop();
        partialInOrder(top.right); // when ever you see a right, push the right into the stack
        return top.val;

    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

}
*/

/* 3:
// Time Complexity : O(1)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes, with optimized approach


// Your code here along with comments explaining your approach
/*Approach
1)the approach is to have O(1) time and O(h) space, thus we use controlled recrusion and not accessing all elements at once.
2) for this, we just carry out dfs and just put left elements in stack (inorder traversal). We do not consider right side.
3) thus with every next call() to iterator, we pop the most recent element and then check if the treenode has right elements.
4) if it has then we again push all left children of the right child of the popped element
5) pop elements



import java.util.*; 
class BSTIterator {

    public class TreeNode {
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


    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        
        stack = new Stack<>();
        dfs(root);
        
    }
    
    public int next() {
        
        TreeNode node = stack.pop();
        dfs(node.right);
        return node.val;
        
    }
    
    public boolean hasNext() {
        
        return !stack.isEmpty();
    }
    
    // controlled recursion to achieve O(h) space complexity
    // we just put the left elements at first and not right;
    public void dfs(TreeNode root)
    {
        
        
        while(root!=null)
        {
            stack.push(root);
            root=root.left;
        }
    }
}
*/