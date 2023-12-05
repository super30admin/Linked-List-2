public class DeleteWithOutHeadPointer {
    void deleteNode(Node del)
    {
        // Your code here
        if(del!=null && del.next!=null)
        {
            del.data=del.next.data;
            del.next=del.next.next;
        }
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
