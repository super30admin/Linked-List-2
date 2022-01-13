package linkedList2;

public class DeleteWithoutHeadPointer {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	//Time Complexity : O(1)
	//Space Complexity : O(1)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = node.next.next;
    }
}
