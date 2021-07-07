// Time complexity is O(N) i.e O(N) + O(N) + O(N) equalvilent to O(N)
// space complexity is O(1) as we are not using any extra space.
// This solution is submitted on leetcode

public class BigN51ReorderigOfTheLinkedList {
	public void reorderList(ListNode head) {
		// edge
		if (head == null || head.next == null)
			return;
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		fast = reverse(slow.next);
		slow.next = null;
		slow = head;
		while (slow != null && fast != null) {
			ListNode temp = slow.next;
			slow.next = fast;
			fast = fast.next;
			slow.next.next = temp;
			slow = temp;
		}
	}

	private ListNode reverse(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		ListNode next = head.next;
		while (next != null) {
			curr.next = prev;
			prev = curr;
			curr = next;
			next = next.next;
		}
		curr.next = prev;
		return curr;
	}
}
