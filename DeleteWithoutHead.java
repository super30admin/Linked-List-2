// Time Complexity : O(1)
// Space Complexity : O(1)

public class DeleteWithoutHead {
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
    void deleteNode(Node del)
    {
        int next = del.next.data;
        del.data = next;
        Node temp = del.next;
        del.next = temp.next;
        temp = null;
        return;
    }
}