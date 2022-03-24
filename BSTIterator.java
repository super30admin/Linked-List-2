// Time Complexity : O(n); 
// Space Complexity : O(n);
import java.util.Stack;

class BSTIterator {	
	static class TreeNode {
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
	Stack<TreeNode> stk;
    
    public BSTIterator(TreeNode root) {
        stk= new Stack<TreeNode>();
        helper(root);
    }
    
    private void helper(TreeNode root){
        while(root!=null){
            stk.push(root);
            root=root.left;            
        }
    }
    
    public int next() {
        TreeNode node = stk.pop();
        //If node has right child, find smallest child in right subtree. 
        if(node.right != null){ //O(n) if skewed
            helper(node.right);
        }
        
        return node.val;
    }
    
    public boolean hasNext() {
        return !stk.isEmpty(); //O(1)
    }
	
	
	// Driver code to test above 
    public static void main(String args[]) {    	
    	TreeNode t= new TreeNode(7, new TreeNode(3), new TreeNode(15, new TreeNode(9), new TreeNode(20)));	
    	BSTIterator ob = new BSTIterator(t);
    	
    	System.out.println("Next: "+ob.next());    // return 3
    	System.out.println("Next: "+ob.next());    // return 7
    	System.out.println("Has next? "+ob.hasNext()); // return True
    	System.out.println("Next: "+ob.next());    // return 9
    	System.out.println("Has next? "+ob.hasNext()); // return True
    	System.out.println("Next: "+ob.next());    // return 15
    	System.out.println("Has next? "+ob.hasNext()); // return True
    	System.out.println("Next: "+ob.next());    // return 20
    	System.out.println("Has next? "+ob.hasNext()); // return False		
    } 
}
