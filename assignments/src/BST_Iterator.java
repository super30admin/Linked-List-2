import java.util.*;

public class BST_Iterator {

    // Time: O(n) for constructor, O(1) for next() and hasNext(), Space: O(n) for inorder array
    List<Integer> inorder = new ArrayList();
    public BST_Iterator(TreeNode root) {
        Iterate(root);
        System.out.println(inorder);
    }

    void Iterate(TreeNode root) {
        if (root == null) return;

        Iterate(root.left);
        inorder.add(root.val);
        Iterate(root.right);
    }

    int indx = 0;
    public int next() {
        return inorder.get(indx++);
    }

    public boolean hasNext() {
        return indx+1 <= inorder.size();
    }
}

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