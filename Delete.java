public class Delete {
    void deleteNode(Node del) {
        if (del == null) {
            return;
        }

        while (del.next != null && del.next.next != null) {
            del.data = del.next.data;
            del = del.next;
        }
        del.data = del.next.data;
        del.next = null;

    }
}
