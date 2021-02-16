// Time complexity - O(1)
// Space complexity - O(1)
// Works on GeeksForGeeks

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
         if (node == null){
             return;
         }
         // Store the data of next node in current node.
         // Move ref of current node from next node to the node after that
         node.data = node.next.data;
         node.next = node.next.next;
    }
}
