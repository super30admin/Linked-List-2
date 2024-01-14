public class DeleteNode {
// Time Complexity : O(1)
// Space Complexity : O(1) 

    
    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            // Invalid input or cannot delete the last node
            return;
        }

        // Copy the value of the next node to the current node
        node.val = node.next.val;

        // Skip the next node
        node.next = node.next.next;
    }

    public static void main(String[] args) {
       
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);

      
        ListNode nodeToDelete = head.next;

        // Create an instance of DeleteNode class
        DeleteNode deleteNode = new DeleteNode();

        // Delete the node
        deleteNode.deleteNode(nodeToDelete);

        // Print the remaining nodes
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
