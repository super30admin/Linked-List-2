// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes (GFG)
// Any problem you faced while coding this : None

/*
 * Approach:
 * Since the head is not given, we replace the given node's data with the data
 * of the next node (including it's link), and "remove" the node to the next of
 * the given node.
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
class Solution
{
    void deleteNode(Node del)
    {
        // Your code here
        if(del.next != null) {
            del.data = del.next.data;
            del.next = del.next.next;
        }
    }
}
