/**
Time Complexity : O(1)
Space Complexity : O(1) 
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