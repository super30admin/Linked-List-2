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
// Time Complexity: O(1)
//Space Complexity: O(1)
// Source:  https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1#
class Solution
{
    void deleteNode(Node del)
    {
         
         // Your code here
         Node nextNode=del.next;
        del.data=nextNode.data;
        del.next=nextNode.next;
         nextNode=null;
    
        
    }
}