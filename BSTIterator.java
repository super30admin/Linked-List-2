//Time Complexity:O(1) amortized for next()
//Space Complexity:O(n)
/*Approach 
-keep storing the left child of every node in stack
-for next()-> pop the element from stack if popped element has right again go to left of it like previously
-for hasNext() we just have to check whether the stack is empty or not
*/
import java.util.Stack;

public class BSTIterator {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
   }

   public BSTIterator(TreeNode root){
       dfs(root);
   }

    Stack<TreeNode> stk = new Stack<>();
    public boolean hasNext(){
        return !stk.isEmpty();
    }

    public TreeNode next(){
        TreeNode result = stk.pop();
        dfs(result.right);
        return result;

    }

    private void dfs(TreeNode root){
        while(root!= null){
            stk.push(root);
            root= root.left;
        }
    }

    public static void main(String args[]){
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(9);
        
        root.right = new TreeNode(50);
        root.right.left = new TreeNode(30);
        root.right.right = new TreeNode(55);

        BSTIterator obj = new BSTIterator(root);
        while(obj.hasNext())
        {System.out.println(obj.next().val);}
        
     }
}