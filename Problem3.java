package linkedList2;

/**
 * 
 * The approach used here is that we take the next node from the node to be
 * deleted and copy its value to the node to be deleted. And we delete that
 * node.
 * 
 * Time Complexity : O(1)
 * 
 * Space Complexity : O(1)
 * 
 * Did this code successfully run on Leetcode : no as the problem is not
 * present, it ran correctly on geeksforgeeks
 * 
 * Any problem you faced while coding this : No
 */
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

public class Problem3 {


	//Function to delete a node without any reference to head pointer.
	class Solution
	{
	    void deleteNode(Node del)
	    {
	         // Your code here
	         Node temp=del.next;
	         del.data=temp.data;
	         del.next=temp.next;
	         temp.next=null;
	         temp=null;
	    }
	}
}
