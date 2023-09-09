// TC : For deleteNode() - O(1)
// SC : O(1)

package S30_Codes.Linked_List_2;

public class DeleteWithoutHeadPointer {
}

class TNode
{
	int data ;
	TNode next;
	TNode(int d)
	{
		data = d;
		next = null;
	}
}


//Function to delete a node without any reference to head pointer.
class Solution2
{
    void deleteNode(TNode del)
    {
        // Your code here
        del.data = del.next.data;
        del.next = del.next.next;
    }
}

