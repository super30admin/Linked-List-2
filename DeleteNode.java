public class DeleteNode {
    // Time Complexity : O(1)
    // Space Complexity : O(1)
    // Did this code run successfully on Leetcode : Yes
    public void deleteNode(Node del_node) {
        // code here
        if (del_node == null ||del_node.next == null ) return;
        del_node.data = del_node.next.data;
        del_node.next = del_node.next.next;

    }
}