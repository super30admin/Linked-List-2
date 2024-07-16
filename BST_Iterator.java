import java.util.Stack;

public class BST_Iterator {
    /* The following is a crude force solution which passes all the testcases of Leetcode.
    But this is not the correct approach as it only can deal with static input. Since all testcases on leetcode
    are static only, this worked here. But in case the nodes in tree change dynamically, this solution
    would have failed. Hence, we use the iterator approach instead of this.

    int index;
    List<Integer> valueList;

    public BST_Iterator(TreeNode root) {
        this.valueList = new ArrayList<>();
        inorder(root);
    }

    public void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        valueList.add(root.val);
        inorder(root.right);
    }

    public int next() {
        return valueList.get(index++);
    }

    public boolean hasNext() {
        return (valueList.size() > index);
    }

     */

    Stack<TreeNode> stack; //Using physical stack to mimic the controlled recursion flow

    public BST_Iterator(TreeNode root) {
        this.stack = new Stack<>(); //O(1) amortized S.C, max value is height of tree
        dfs(root);
    }

    public void dfs(TreeNode root) { //perform dfs on left side of the tree
        while(root != null) { //O(1) amortized T.C
            stack.push(root); //push all left children from root until null to stack
            root = root.left;
        }
    }

    public int next() { //as this is controlled recursion,
        TreeNode popped = stack.pop(); //we pop the node first
        dfs(popped.right);  //and then proceed to perform dfs on right side
        return popped.val; //return the current root value as next
    }

    public boolean hasNext() {
        return !stack.isEmpty(); //if the stack is not empty, that means there is always a next element
    }

    public static void main(String[] args) {
        // Creating a binary search tree
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        // Initializing the BST iterator
        BST_Iterator iterator = new BST_Iterator(root);

        // Using the iterator to print all elements in sorted order
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}