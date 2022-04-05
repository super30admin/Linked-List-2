// Time Complexity : O(1)- changing for just the give node
// Space Complexity : O(1) - cosntant time
// Did this code successfully run on Leetcode : Not present on leetcode
// Any problem you faced while coding this : No
// My Notes : Copy the next node data and skip the next node
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
         del.data = del.next.data;
         del.next = del.next.next;
    }
}