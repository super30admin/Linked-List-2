// Time Complexity : 
// Constructor: O(h), where h is the height of the tree.
// next(): O(1) 
// hasNext(): O(1)

// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Used a stack to simulate in-order traversal iteratively.
// On initialization, pushed all left children of the root.
// next() pops the top of the stack and processes the right subtree.
// hasNext() checks if the stack has more nodes to process.
// This gives us the next smallest number on each call to next().



import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode () {}

    TreeNode(int val){
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}



class BSTIterator {
    Stack<TreeNode> s;
    public BSTIterator(TreeNode root){
        s = new Stack<>();
        dfs(root);

    }

    public int next(){
        TreeNode popped = s.pop();
        dfs(popped.right);
        return popped.val;


    }


    public boolean hasNext() {
        return !s.isEmpty();

    }

    private void dfs(TreeNode root){
        while(root!=null){
            s.push(root);
            root=root.left;
        }
    }


    public static void main(String[]args){
        TreeNode root = new TreeNode(7,
                            new TreeNode(3),
                            new TreeNode(15, new TreeNode(9), new TreeNode(20)));

        
        BSTIterator ob = new BSTIterator(root);
        while(ob.hasNext()){
            System.out.print(ob.next()+ " ");
        }




    }

}