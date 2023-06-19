package linkedList2;

/**
 * 
 * For the given linkedlists, we find the length of both and adjust the start of
 * the larger list such that length from start to end will be same for both
 * lists. Then we traverse both lists together by one and wherever they meet is
 * the intersection point.
 * 
 * Time Complexity : O(m+n), where m and n are the lengths of the given lists.
 * 
 * Space Complexity : O(1)
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 */
public class Problem4 {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode first = headA;
		ListNode second = headB;
		int lenA = 0;
		int lenB = 0;

		while (first != null || second != null) {
			if (first != null) {
				first = first.next;
				lenA++;
			}
			if (second != null) {
				second = second.next;
				lenB++;
			}

		}

		if (lenB > lenA) {
			int i = 0;
			while (i < lenB - lenA) {
				headB = headB.next;
				i++;
			}
		} else if (lenA > lenB) {
			int i = 0;
			while (i < lenA - lenB) {
				headA = headA.next;
				i++;
			}
		}
		while (headA != headB) {
			headA = headA.next;
			headB = headB.next;
		}

		return headA;
	}
}
