import java.util.Stack;

public class BSTIterator {
    private Stack<TreeNode> stack;

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

    public BSTIterator(TreeNode root) {
        stack= new Stack<>();
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode curr = stack.pop();
        int data = curr.val;
        if(curr.right != null){
            curr = curr.right;
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            } 
        }
        return data;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
