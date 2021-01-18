//Time Complexity: O(1)
//Space Complexity: O(1)

//Successfully runs on GFG: 1.65 ms

//Approach: To delete the node whose reference is given, we just make the node data equal to its next node data
//and also change its next pointer to the next of its next node and GC can take care for clearing the memory.


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

// This function should delete node from linked list. The function
// may assume that node exists in linked list and is not last node
// node: reference to the node which is to be deleted
class GfG
{
    void deleteNode(Node node)
    {
         // Your code here
         node.data = node.next.data;
         node.next = node.next.next;
    }
}