// } Driver Code Ends


/*
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
*/
//TC: O(1)
//SC: O(1)
//Function to delete a node without any reference to head pointer.
class DeleteWithoutHeadPointer
{
    void deleteNode(Node del)
    {
         // Your code here
         del.data = del.next.data;
         del.next = del.next.next;
    }
}


