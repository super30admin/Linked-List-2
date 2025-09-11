import java.util.Stack;
//Time Complexity: O(h)
//Space Complexity: Amortized O(1)
// Did this code successfully run on Leetcode : Yes
//Approach: We use lazy evaluation by only pushing left children into the stack when needed.
//When next() is called, we pop the top, return its value, and push its right child’s left path. hasNext() just checks if the stack still has nodes left to process.
//Lazy evaluation is usually expected in iterator problems to avoid unnecessary traversal and memory usage upfront.
public class BSTIterator {

    private final Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        dfs(root);
    }

    public int next() {
        TreeNode node = stack.pop();
        dfs(node.right);

        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void dfs(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public static void main(String[] args) {
        TreeNode leftValid = new TreeNode(6);
        leftValid.left = new TreeNode(4);
        leftValid.left.left = new TreeNode(3);
        leftValid.left.right = new TreeNode(5);
        leftValid.right = new TreeNode(7);
        leftValid.right.right = new TreeNode(9);

        TreeNode rightValid = new TreeNode(15);
        rightValid.left = new TreeNode(13);
        rightValid.left.left = new TreeNode(12);
        rightValid.right = new TreeNode(18);
        rightValid.right.left = new TreeNode(17);
        rightValid.right.right = new TreeNode(20);

        TreeNode valid = new TreeNode(10, leftValid, rightValid);

        BSTIterator bSTIterator = new BSTIterator(valid);
        System.out.println(bSTIterator.next());    //return 3
        System.out.println(bSTIterator.next());    //return 4
        System.out.println(bSTIterator.hasNext()); //true
        System.out.println(bSTIterator.next());    //return 5
        System.out.println(bSTIterator.hasNext()); //true
        System.out.println(bSTIterator.next());    //return 6
        System.out.println(bSTIterator.hasNext()); //true
        System.out.println(bSTIterator.next());    //return 7
        System.out.println(bSTIterator.hasNext()); //true
        System.out.println(bSTIterator.next());    //return 9
        System.out.println(bSTIterator.next());    //return 10
        System.out.println(bSTIterator.hasNext()); //true

        System.out.println(bSTIterator.next());    //return 12
        System.out.println(bSTIterator.next());    //return 13
        System.out.println(bSTIterator.hasNext()); //true
        System.out.println(bSTIterator.next());    //return 15
        System.out.println(bSTIterator.next());    //return 17
        System.out.println(bSTIterator.next());    //return 18
        System.out.println(bSTIterator.hasNext()); //true
        System.out.println(bSTIterator.next());    //return 20
        System.out.println(bSTIterator.hasNext()); //false
        System.out.println(bSTIterator.next()); //EmptyStackException
    }
}
