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
class DeleteNode
{

    // Time Complexity: O(1)
    // Space Complexity: O(1)

    void deleteNode(Node node)
    {
        // Edge Case Checking
        if(node == null || node.next == null)
            return;

        // Keep a reference pointer to next node
        Node temp = node.next;
        
        // Copy the data of next node to current node
        node.data = temp.data;

        // Copy the next -> next address to current node
        node.next = temp.next;
    }
}