//Time Complexity: O(1)
//Space Complexity: O(1)

/**
 * Deletes a given node from a linked list without access to the head pointer.
 * The node’s data is replaced with the next node’s data, and the next pointer is updated.
 * This approach effectively removes the node by bypassing it in the list.
 */

class Node {
    int data;
    Node next;
    
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DeleteNodeWithoutHeadPointer {
    // Function to delete a node without any reference to head pointer.
    void deleteNode(Node nodeToDelete) {
        // Your code here
        nodeToDelete.data = nodeToDelete.next.data;
        nodeToDelete.next = nodeToDelete.next.next;
    }
}