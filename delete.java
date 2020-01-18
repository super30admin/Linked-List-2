// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on GeeksForGeeks : Yes
// Any problem you faced while coding this : No

/*class Node
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
        Node temp = node;
        while(node.next.next != null){		// logic -  move the next data to the current data, by this we are deleting the node which was given to us
            node.data = node.next.data;
            node = node.next;				// move forward
        }
        
        node.data = node.next.data;			// once we reach the second last element, do the swap one time and point the node to null
        node.next = null;
    }
}

