
/**
   GFG: Delete without head pointer

    Working:
        get the nextNode
        set the value and next reference of the current with the nextNode value, reference
        set nextNode.next = null i.remove the link for the nextNode

    Time Complexity: O(1)
    Space Complexity: O(1)

*/

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
class DeleteNodeWithoutHead
{
    void deleteNode(Node node)
    {
        Node nextNode = node.next;

        node.data = nextNode.data;
        node.next = nextNode.next;
        nextNode.next = null;
    }
}

