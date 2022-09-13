// Time Complexity : O(1)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : geeks of geeks problem, yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/**
 * In order to delete a node, without reference to the head, we will move the value of next node to the
 * node to be deleted and then make delete node point to next to next node. Basically, we are moving the values in order to
 * delete the node. In oredre to actuaaly remove the node, we need a refernce to head . So we are overwriting the values.
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
class Problem3
{
    void deleteNode(Node del)
    {
        // Your code here

        del.data = del.next.data;
        del.next = del.next.next;
    }
}

