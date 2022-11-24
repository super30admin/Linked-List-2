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
class Solution
{
    void deleteNode(Node del)
    {
         // Your code here
         Node temp = del.next;
       del.data = temp.data;
       del.next = temp.next;
       temp.next = null;
    }
}
