// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on GeeksForGeeks : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
copy the next node's val to current and point the current node's pointer to next next
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

        //copying the data of next's pointer in the given current node.
        del.data = del.next.data;

        //skipping the next node by joining next next's node to current node.
        del.next = del.next.next;

    }
}
