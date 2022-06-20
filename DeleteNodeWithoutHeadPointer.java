//Time Complexity=O(1)
//Space Complexity=O(1)
public class DeleteNodeWithoutHeadPointer {

    void deleteNode(Node del)
    {
        // Your code here
        //  int temp=del.data;
        del.data=del.next.data;
        del.next=del.next.next;
    }
}
