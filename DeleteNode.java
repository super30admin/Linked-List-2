// Time Complexity : O(1), as we only perform a constant number of operations.
// Space Complexity : O(1), no extra space is used.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//
// Approach : 
// Normally, to delete a node in a singly linked list, we need access to the previous node.
// But here we are only given the node to delete (not the head).
// The trick is to copy the value of the next node into the current node,
// and then bypass the next node by changing pointers. This effectively "deletes" the node
// without needing the previous reference. 
// Limitation: This method cannot delete the tail node, because there is no next node to copy.

class DeleteNode {
    public void deleteNode(Node deletenode) {
        // edge case: if node is null or it's the last node, we cannot delete
        if (deletenode == null || deletenode.next == null) {
            return; 
        }

        // copy data from next node
        Node temp = deletenode.next;
        deletenode.data = temp.data;

        // skip the next node
        deletenode.next = temp.next;
    }
}


// Definition for singly linked list node
class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}
