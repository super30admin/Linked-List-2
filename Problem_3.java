// Delete without head pointer
// Time Complexity : O(1)
// Space Complexity : O(1)

// Approach
// Copy the data of next node to the node which we want to delete
// delete the next node and make pointer to next of next

/*
class Node {
	int data ;
	Node next;
	Node(int d) {
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
