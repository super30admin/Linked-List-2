// Time Complexity : O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : No, Geeks For Geeks
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * Since the head reference is not given, we do have the pointer to the node to be deleted. 
 * We will store the data field of the next node into the current node and point the next pointer of 
 * current node to the next of next pointer.
 */
//https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1
public class Solution {
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
    void deleteNode(Node del)
    {
         // Your code here
         del.data = del.next.data;
         del.next = del.next.next;
    }
}