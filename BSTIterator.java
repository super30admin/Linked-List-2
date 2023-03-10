
public class BSTIterator {
    List<Integer> li;
    int i;

    public BSTIterator(TreeNode root) {
        li = new ArrayList<Integer>();
        inorder(root);
    }

    private void inorder(TreeNode root){
        if(root==null) return;

        inorder(root.left);
        li.add(root.val);
        inorder(root.right);
    }
    
    public int next() {
        int ele = li.get(i);
        i++;
        return ele;
    }
    
    public boolean hasNext() {
        return i!=li.size();
    }   
}

// TC - O(1)
// SC - O(1)

public class BSTIterator {
    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        helper(root);
    }
    private void helper(TreeNode root){
        while(root!=null){
            st.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode node = st.pop();
        helper(node.right);
        return node.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}

// TC - avg - O(1) , worst - O(h) , h - height of the tree
// SC - O(1)