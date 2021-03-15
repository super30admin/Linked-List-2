// Time Complexity :O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Ran on geeks for geeks
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// In this approach we just copy the value that is in the node next to the one to be deleted to the current position and make the next as the 
// next of the node from which we copied the value.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
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

// This function should delete node from linked list. The function
// may assume that node exists in linked list and is not last node
// node: reference to the node which is to be deleted
class Solution
{
    void deleteNode(Node node)
    {
         // Your code here
         //copy the value of next node to the current node
         node.data = node.next.data;
         //make the next of current as the one after the next node
         node.next = node.next.next;
    }
}

