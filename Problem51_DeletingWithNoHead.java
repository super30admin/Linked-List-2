/***************Time Complexity: O(n) **************** */

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


class Solution
{
	void deleteNode(Node val)
	{
		Node temp = val.next;       //temporary Node
		val.data = temp.data;       //data copying from Node to temp
		val.next = temp.next;       //pointing to the next
		val = null;                
	}
}