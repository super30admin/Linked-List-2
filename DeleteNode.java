/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 * */
public class DeleteNode {
    void deleteNode(Node del) {
        del.data = del.next.data;
        del.next = del.next.next;
    }
}

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}