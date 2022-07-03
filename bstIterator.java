
// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
import java.util.*;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Main {
    // for controller recursion
    private Stack<TreeNode> stk = new Stack<>();

    public Main(TreeNode root) {
        // constructor
        dfs(root);
    }

    public void dfs(TreeNode root) {
        // stop recursion at left most element
        while (root != null) {
            stk.push(root);
            root = root.left;
        }
    }

    public int next() {
        // get top from the stack
        TreeNode nextVal = stk.pop();
        // do right recursion call of this nextVal
        dfs(nextVal.right);
        // return value of top element in stack
        return nextVal.val;
    }

    public boolean hasNext() {
        // if stack is empty there is no element in the tree so we return false or
        // return true
        return !stk.isEmpty();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);
        Main main = new Main(root);
        while (main.hasNext()) {
            System.out.print(main.next() + " ");
        }
    }
}