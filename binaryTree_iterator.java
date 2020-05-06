// Time Complexity : next: amortised O(1), hasNext: O(1)
// Space Complexity : next: O(N), hasNext: O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Couldn't solve by own


// Your code here along with comments explaining your approach:
//Since this is a binary search tree, the lowest elemet is present at the end of leftmost leafnode. Therefore, first iterate through the leftside nodes in iterator.
//Then, in next pop the topmost element. Then, check whether a rightside element is present. Then insert all of it's left side elements.

class BSTIterator {

    //initialize our stack
    Stack<TreeNode> s;
    
    public BSTIterator(TreeNode root) {
        s = new Stack<>();
        
        TreeNode cursor = root;
        
        //pushing left side elements into stack
        while(cursor != null){
            s.push(cursor);
            cursor = cursor.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        //node at top of stack is smallest element
        TreeNode res = s.pop();
        
        //there can nodes present on right side
        TreeNode cursor = res.right;
        
        //push all it's left nodes to stack
        while(cursor != null){
            s.push(cursor);
            cursor = cursor.left;
        }
        
        return res.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s.isEmpty();
    }
}