// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
 * 1. Idea is  to find the length difference between two lists and compare eahc node while traversing.
 * 2. when ever a pointer reached end of the list point it to head of other other list.
 */

public class IntersectionOf2Lists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode p1 = headA;
		ListNode p2 = headB;

		while (p1 != p2) {
			p1 = p1 == null ? headB : p1.next;
			p2 = p2 == null ? headA : p2.next;
		}
		return p1;
	}
}

public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}
