// Time Complexity - O(1) we are not traversing to the entire list. We are given reference to the node that needs to be delected.
// Space Complexity - O(1) no extra space is used
// We need to swap the data of the node that needs to be deleted with the next node data and then delete the next node. 

void deleteNode(Node node)
    {
        node.data = node.next.data;
        node.next = node.next.next;
    }
