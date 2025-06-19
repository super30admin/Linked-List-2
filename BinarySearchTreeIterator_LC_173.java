import java.util.Stack;

//When designing Data structure we have to calculate amortised time complexity
//Time complexity -  Amortised O(1) and worse case O(H) h is height of tree
//Space Complexity - O(1)
public class BinarySearchTreeIterator_LC_173 {

    Stack<Node> st;
    public BSTIterator(Node root) {
        this.st = new Stack<>();
        dfs(root);

    }
    private void dfs(Node root) {
        while(root != null){
            st.push(root);
            root = root.left;
        }
    }

    public int next() { //in worst case time complexity - O(H)
        Node curr = st.pop();
        dfs(curr.right);
        return curr.val;
    }

    public boolean hasNext() { //O(1)
        return !st.isEmpty();

    }
}
class Node {
    int val;
    Node left;
    Node right;
    Node() {}
    Node(int val) { this.val = val; }
    Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}