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
// TC : O(1)
// SC : O(1)
class Solution
{
    void deleteNode(Node del)
    {
         // Your code here
         if(del.next != null){
            del.data = del.next.data;
            del.next = del.next.next;
         }
    }
}
