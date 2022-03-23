//Time and Space Complexity O(1)
//GeeksForGeek tested
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
public class DeleteWithoutHeadPointer {
    void deleteNode(Node del)
    {
        if(del.next != null) {
            del.data=del.next.data;
            del.next=del.next.next;
        }else del = null;
    }
}
