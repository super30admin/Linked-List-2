/*
Binary Search Tree Iterator
approach: we need a controlled recursion, so make use of a stack. initially add all the left nodes to the stack.
when next is called, pop the top and add all left nodes of right subtree of popped element. repeat.

time: O(h)
space: O(h)
 */
public class Problem1 {
    /*
class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack();
        while(root!=null) {
            stack.add(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode pop = stack.pop();
        TreeNode nextNode = pop.right;

        while(nextNode!=null) {
            stack.add(nextNode);
            nextNode = nextNode.left;
        }

        return pop.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}*/

}
