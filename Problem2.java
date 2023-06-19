package linkedList2;

/**
 * 
 * We find the middle element and then reverse the second half of the
 * linkedlist. Then we connect elements of the unreversed list with the first
 * element of the reversed list and from that element of the reversed list to
 * the next element in unreversed list in an iterative manner to form the ans.
 * 
 * Time Complexity : O(n)
 * 
 * Space Complexity : O(1)
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Problem2 {
	public void reorderList(ListNode head) {
		if (head.next == null)
			return;
		int counter = 0;
		ListNode slow = head;
		ListNode prev = null;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			prev = slow;
			slow = slow.next;

		}
		prev.next = null;

		fast = reverse(slow);
		slow = head;
		ListNode temp;

		while (slow.next != null) {
			temp = slow.next;
			slow.next = fast;
			slow = temp;
			temp = fast.next;
			fast.next = slow;
			fast = temp;
		}
		slow.next = fast;

		while (head != null) {
			head = head.next;
		}

	}

	ListNode reverse(ListNode node) {
		if (node.next == null)
			return node;
		ListNode prev = null;
		ListNode curr = node;
		ListNode fast = node.next;

		while (fast != null) {
			curr.next = prev;
			prev = curr;
			curr = fast;
			fast = fast.next;
		}

		curr.next = prev;

		return curr;

	}
}
