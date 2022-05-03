import java.util.*;
public class BSTIterator {
    
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
		TreeNode node = root;
		updateStack(node); 
    }
    
    public int next() {
        TreeNode toRemove = stack.pop();
		updateStack(toRemove.right);                             
		return toRemove.val;
    }
    
    public boolean hasNext() {
        
        return !stack.isEmpty(); 
        
    }
    
    public void updateStack(TreeNode node){
		while(node != null){
			stack.add(node);
			node = node.left;
		}
	}
}
