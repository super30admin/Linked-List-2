import java.util.ArrayList;
import java.util.List;
/*
Time Complexity: overall O(N), both method will have O(N) complexity, N is the number of nodes we have in tree
Space Complexity: O(N) using ArrayList
run on leetcode: yes
Any difficulties : no

Approach:
1. First I am Iterating BST using inorder traversal and storing every element in the list
2. my index pointer will be at the node and in case of arraylist it would point to the mid element, if it has right child
it would return true in hasNext otherwise false
 */
public class BinarySearchTreeIterator {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    private static List<Integer> sortedList;
    private static int index;
    public BinarySearchTreeIterator(TreeNode root){
        sortedList = new ArrayList<>();
        index = -1;
        inorder(root);
    }
    public static void inorder(TreeNode root){
        if(root == null){
            return;
        }

        inorder(root.left);
        sortedList.add(root.val);
        inorder(root.right);
    }

    public static int next(){
        return sortedList.get(++index);
    }

    public static boolean hasNext(){
        return index+1< sortedList.size();
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);
        BinarySearchTreeIterator obj = new BinarySearchTreeIterator(root);

        System.out.println("Next Element: "+ obj.next());
        System.out.println("Next Element: "+ obj.next());
        System.out.println("Next Element: "+ obj.next());
        System.out.println("Next Element: "+ obj.next());
        System.out.println("Next Element: "+ obj.next());

        System.out.println("Has Next: "+ obj.hasNext());

    }
}
