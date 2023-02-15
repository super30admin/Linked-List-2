// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

// Your code here along with comments explaining your approach

/**
 * First, we have to find the mid using the slow & fast pointer approach.
 * Then, reverse the second half of the list. make the first half's mid.next as null.
 * Now, using take two pointers p1 & p2 pointing to head and reversed 2nd half.
 * update p1's next with p2 and p2's next as p1's next.
 *
 */
class Solution {
	public void reorderList(ListNode head) {
		if (head == null)
			return;
		ListNode mid = findMid(head);
		ListNode rev = reverse(mid.next);
		mid.next = null;
		ListNode ptr1 = head, ptr2 = rev;
		while (ptr1 != null && ptr2 != null) {
			ListNode fNext = ptr1.next;
			ListNode sNext = ptr2.next;
			ptr1.next = ptr2;
			ptr2.next = fNext;
			ptr1 = fNext;
			ptr2 = sNext;
		}
	}

	public ListNode findMid(ListNode head) {
		if (head == null)
			return null;
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public ListNode reverse(ListNode head) {
		if (head == null)
			return null;
		ListNode prev = null, curr = head;
		while (curr != null) {
			ListNode node = curr.next;
			curr.next = prev;
			prev = curr;
			curr = node;
		}
		return prev;
	}
}