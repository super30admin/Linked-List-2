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
// Time Complexity: For tree Construction-> O(height), next()-> O(height) => In the worst case O(n), hasNext()->O(1)
// But the average time complexity/ amortized time complexity for next() -> O(1)
// Space Complexity: For creating stack ->O(n)
// Leetcode: 173. Binary Search Tree Iterator
// Approach: Controlled recursion
class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack=new Stack<>();
        dfs(root);
    }
    
    public void dfs(TreeNode node)
    {
        if(node==null)
            return ;
        stack.push(node);
        dfs(node.left);
    }
    public int next() {
        int res=-1;
        if(hasNext())
        {
            TreeNode node=stack.pop();
            res=node.val;
            dfs(node.right);           
            
        }
        return res;
    }
    
    public boolean hasNext() {
        
        return stack.size()>0 ;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

/*
// Time Complexity: For tree Construction-> O(n), next()-> O(1), hasNext()->O(1)
// Space Complexity: For creating list ->O(n)
// Leetcode: 173. Binary Search Tree Iterator
// Approach: Flattening the BST
class BSTIterator {
ArrayList<TreeNode> list;
    int index;
    int length;
    public BSTIterator(TreeNode root) {
        list=new ArrayList<>();
        index=0;
        inorder(root);
        length=list.size();
    }
    
    public void inorder(TreeNode root)
    {
        //base
        if(root==null)
            return;
        //logic
        inorder(root.left);
        list.add(root);
        inorder(root.right);
    }
    public int next() {
        if(hasNext())
        {
            index++;
            return list.get(index-1).val;
        }
        return -1;
    }
    
    public boolean hasNext() {
        if(index+1> length)
            return false;
        
        return true;
    }
}

*/