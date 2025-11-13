class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

class Solution {
    // Function to delete the given node
    void deleteNode(Node del_node) {
        if (del_node == null || del_node.next == null) {
            // Can't delete the last node with this method
            return;
        }

        // Copy data from the next node into this node
        del_node.data = del_node.next.data;

        // Bypass the next node
        del_node.next = del_node.next.next;
    }
}


Time Complexity : O(1) 
Space Complexity : O(1) 