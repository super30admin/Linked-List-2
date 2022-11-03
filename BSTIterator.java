package s30.linkedList.linkedList2;

import s30.trees.TreeNode;

import java.util.Stack;

// for hasNext method
// Time Complexity O(1)  Space Complexity O(1)

// for next method
// Time Complexity O(1) ; we are iterating through the further left nodes only few times.
// Space Complexity O(1)

public class BSTIterator {
    private Stack<TreeNode> nodes;

    public BSTIterator(TreeNode root) {
        nodes = new Stack();

        pushLeft(root);
    }

    private void pushLeft(TreeNode node){

        while(node!=null){
            nodes.push(node);
            node = node.left;
        }
    }

    public int next() {
        TreeNode node = nodes.pop();

        if(node.right!= null) pushLeft(node.right);

        return node.val;
    }

    public boolean hasNext() {
        return !nodes.isEmpty();
    }
    public static void main(String[] args) {

    }
}
