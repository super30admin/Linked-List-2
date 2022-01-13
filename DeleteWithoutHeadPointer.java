// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on geeksforgeeks : Yes

public class DeleteWithoutHeadPointer {
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

    //Function to delete a node without any reference to head pointer.
    void deleteNode(Node del)
    {
        del.data = del.next.data;
        del.next = del.next.next;
    }
}
