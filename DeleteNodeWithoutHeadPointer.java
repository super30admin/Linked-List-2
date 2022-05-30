/**
Time Complexity : O(1)
Space Complexity : O(1) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
**/
class Solution
{
	void deleteNodeWithoutHeadPointer(ListNode node)
	{
		ListNode nextNode = node.next;

		int temp = node.val;
		node.val = nextNode.val;
		nextNode.val = temp;

		node.next = nextNode.next;

	}
}