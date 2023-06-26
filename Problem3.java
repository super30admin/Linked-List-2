// Time Complexity : O(1)
// Space Complexity : O(1)
    // n is the number of nodes present in the linked list.

// Your code here along with comments explaining your approach
    //We copy the second(next of head) node's value to the head node.
	//We then delete the second node, by pointing the next of head to next of second node.
    
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
         // Your code here
         del.data = del.next.data;
         del.next = del.next.next;
    }
}