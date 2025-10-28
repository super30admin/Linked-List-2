/**
 * Link : https://www.geeksforgeeks.org/problems/delete-without-head-pointer/1
 * <p>
 * Approaches:
 * <p>
 * 1. Iterative Data Copy Approach:
 * - Since the head pointer is not available, we cannot access the previous node.
 * - Copy the data from the next node into the current node to be deleted.
 * - Repeat this process for all subsequent nodes until the last node is reached.
 * - Remove the last node by setting the next pointer of the second last node to null.
 * - This effectively deletes the given node from the list without needing the head pointer.
 */

public class DeleteNodeWithOutHead {

    public void deleteNode(Node del_node) {

        Node previous = null;
        Node current = del_node;

        while (current != null && current.next != null) {
            current.data = current.next.data;
            previous = current;
            current = current.next;
        }
        previous.next = null;
    }

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
}
