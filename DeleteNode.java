// Time Complexity : O(1), because we just copy and re-link one node
// Space Complexity : O(1), no extra space used
// Did this code successfully run on GFG : Yes
// Any problem you faced while coding this : No

// Approach:
// - We are not given the head of the linked list, only the node to delete.
// - Since we can’t access the previous node, we cannot simply bypass it.
// - Instead, copy the value from the *next* node into the current node.
// - Then skip the next node by updating current.next to next.next.
// - This effectively deletes the given node from the list.

public class DeleteNode {
    public void deleteNode(Node del_node) {
        if (del_node == null || del_node.next == null) {
            // Edge case: if node is null or last node, we can't delete like this
            return;
        }
        del_node.data = del_node.next.data;      // copy next node’s data
        del_node.next = del_node.next.next;      // unlink next node
    }

    // --- Main method for testing ---
    public static void main(String[] args) {
        // Create list: 1 -> 2 -> 3 -> 4
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        System.out.println("Original list:");
        printList(head);

        DeleteNode ops = new DeleteNode();

        // Delete node with value 3 (without head)
        ops.deleteNode(head.next.next);

        System.out.println("\nAfter deleting node with value 3:");
        printList(head);

        // Delete node with value 2
        ops.deleteNode(head.next);

        System.out.println("\nAfter deleting node with value 2:");
        printList(head);
    }

    // Helper function to print list
    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}

// Definition for singly-linked list node.
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

