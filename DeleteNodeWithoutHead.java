/*
Approach
Since we don't have the previous node, copy the next node's data into the current node x.
Update x.next to x.next.next, effectively removing the next node.
The current node now represents the node that needed to be deleted.

Time Complexity: O(1)
Space Complexity: O(1)
*/
class DeleteNodeWithoutHead {

    void deleteNode(Node x) {

        // Copy data from the next node
        x.data = x.next.data;

        // Skip the next node
        x.next = x.next.next;
    }
}

