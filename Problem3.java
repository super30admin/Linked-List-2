//Space complexity : o(1)
//Time complexity : o(1)
    
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

//Function to delete a node without any reference to head pointer.
public class Problem3 {
{
    void deleteNode(Node del)
    {
         // When you dont have headpointe, simply copy the node next to delete node into delete node
         del.data=del.next.data;
         del.next=del.next.next;
    }
}
}
