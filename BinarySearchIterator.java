// TIME: O(n)
// SPACE: O(n)
// SUCCESS on LeetCode

public class BinarySearchIterator {
    private List<Integer> nodesList;
    private int count;
    public BSTIterator(TreeNode root) {
        nodesList = new ArrayList<>();
        nodesList = inorder(root);
    }
    
    private List<Integer> inorder(TreeNode node) {
        if (node == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.addAll(inorder(node.left));
        list.add(node.val);
        list.addAll(inorder(node.right));
        return list;
    }
    
    public int next() {
        return nodesList.get(count++);
    }
    
    public boolean hasNext() {
        if (count >= nodesList.size()) return false;
        return true;
    }
}


