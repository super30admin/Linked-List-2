// Time Complexity : O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


//Definition for singly-linked list.
/*class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}
*/
public class DeleteNode_LinkedList {
	public void deleteNode(ListNode node) {
		System.out.println("delete node :" + node.val);

		node.val = node.next.val;	// copy value from next node to curr node
		node.next = node.next.next;  // remove reference to the next node

	}
}
