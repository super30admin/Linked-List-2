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
// Time complexity: O(1)
// Space Complexity: O(1)
//Function to delete a node without any reference to head pointer.
class Solution
{
    void deleteNode(Node del)
    {
         // Your code here
         while(del.next != null){
             del.data = del.next.data;
             del.next = del.next.next;
         }
      del=null;
    }
}

