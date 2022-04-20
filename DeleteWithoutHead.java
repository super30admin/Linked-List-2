public class DeleteWithoutHead {
    void deleteNode(Node del)
    {
         if(del.next != null){
            del.data = del.next.data;
            del.next = del.next.next;
        } else {
            del = null;
        }
    }
}
