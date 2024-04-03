class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class Solution {
    // Tc: O(1) Sc: O(1)
    void deleteNode(Node del_node) {
        Node temp = del_node.next;
        del_node.data = temp.data;
        del_node.next = temp.next;
        temp = null;
    }
}
