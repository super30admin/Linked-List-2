/**
Problems: https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1#
TC: O(n)
SC: o(n)
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
         Node prev = del, next = del.next;
         
         while (next != null) {
             prev.data = next.data;
             
             if (next.next == null) {
                 prev.next = null;
                 break;
             }
             prev = next;
             next = next.next;
         }
    }
}