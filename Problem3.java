class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Problem3 {
    public void deleteNode(Node del) {
        if (del == null || del.next == null) {
            // Cannot delete the node if it's the last node
            return;
        }

        del.data = del.next.data;
        del.next = del.next.next;
    }
}
