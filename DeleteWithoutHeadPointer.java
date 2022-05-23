// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on GeekForGeeks : YES
// Any problem you faced while coding this : NO

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
    void deleteNode(Node del)
    {
        if(del.next != null){
            del.data = del.next.data;
            del.next = del.next.next;
        }
        else
        del = null;
         // Your code here
    }
}
