
public class DeleteWithoutHeadPointer {
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    void deleteNode(Node del) {
        // Your code here
        Node temp = del.next;
        del.data = del.next.data;
        del.next = temp.next;
    }
}
