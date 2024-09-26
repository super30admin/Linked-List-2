// Brute Force
// Time Complexity: O(n)
// Space Complexity: O(n) where n is number of nodes in tree
class BSTIterator {

 List<Integer> list = new ArrayList<>();
 int index = 0;

 public BSTIterator(TreeNode root) {
     inorder(root);
 }

 private void inorder(TreeNode root) {
     if(root == null) {
         return;
     }
     inorder(root.left);
     list.add(root.val);
     inorder(root.right);
 }

 /** @return the next smallest number */
 public int next() {
     return list.get(index++);
 }

 /** @return whether we have a next smallest number */
 public boolean hasNext() {
     if(index>=list.size()) {
         return false;
     }
     return true;
 }
}

// Time Complexity for next: O(h) and hasNext: O(1)
// Space COmplexity: O(maxDepth)
class BSTIterator {

    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushAllNodes(root);
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        pushAllNodes(node.right);
        return node.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushAllNodes(TreeNode root) {
        while(root!=null) {
            stack.push(root);
            root = root.left;
        }
    }
}
