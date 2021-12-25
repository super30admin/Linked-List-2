// Time Complexity : O(1)
// Space Complexity : O(1)
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
    public void deleteNode(Node del)
    {
        if(del == null)
            return;
        
        if(del.next == null)
        {
            del = null;
            return;
        }

        del.next = del.next.next;
            
    }
}
