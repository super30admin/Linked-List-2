// Function to delete a node without any reference to head pointer.
//Time and space complexity - O(1)
public class DeletewithoutHeadpointer {
    void deleteNode(ListNode node) {
        // Your code here
        int val = node.next.val;
        node.val = val;
        node.next = node.next.next;
    }
}