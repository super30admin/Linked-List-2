public class Delete_without_head_ptr {
    // Time: O(1), Space: O(1)
    void deleteNode(Node del)
    {
        del.data = del.next.data;
        del.next = del.next.next;
    }
}

class Node
{
    int data ;
    Node next;
    Node(int d)
    {
        data = d;
        next = null;
    }
}