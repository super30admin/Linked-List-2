
// Time Complexity : O(1)
// Space Complexity : O(1)
// Any problem you faced while coding this : No

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
    /*Copy the data of next node to the current node. 
    Then, link the node after the next node to the current node. This way, 
    the required node is removed but its data is saved in the current node.*/
    void deleteNode(Node del)
    {
        Node nextNode = del.next;
        del.data = nextNode.data;
        del.next = nextNode.next;
    }
}
