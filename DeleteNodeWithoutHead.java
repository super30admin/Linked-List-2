//https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1
//TC: o(1)
//SC : o(1)

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
class Solution
{
    void deleteNode(Node del)
    {
         del.data = del.next.data;
         del.next = del.next.next;
    }
}
