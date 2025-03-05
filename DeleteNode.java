

/*
class Node
{
    int data ;
    Node next;
    Node(int d)
    {
        data = d;
        next = null;
    }
}
*/

// Function to delete a node without any reference to head pointer.
class Solution {
    void deleteNode(Node node) {
        if (node == null || node.next == null) {
            throw new IllegalArgumentException("Node to be deleted cannot be null or the last node");
        }

        // Copy data from the next node
        node.data = node.next.data;
        // Skip the next node
        node.next = node.next.next;
    }
}