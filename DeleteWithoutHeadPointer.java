//https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1
// Time Complexity :O(1) 
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

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
        if(del.next!=null) del.data=del.next.data;  //copy the next node value here 
         del.next=del.next.next; //move current node to curr node next next
    }
}