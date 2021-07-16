//Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

public class ReorderList {
	public void reorderList(ListNode head) {
		if (head == null) {
			return;
		}

		// Find middle of Linked List

		ListNode fastPtr = head;
		ListNode slowPtr = head;

		while (fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
		}

		// Reverse second half of list

		ListNode prev = null;

		while (slowPtr != null) {
			ListNode next = slowPtr.next;
			slowPtr.next = prev;
			prev = slowPtr;
			slowPtr = next;
		}

		// Merge Lists

		slowPtr = head;
		while (prev.next != null) {
			ListNode next = slowPtr.next;
			slowPtr.next = prev;
			slowPtr = next;

			next = prev.next;
			prev.next = slowPtr;
			prev = next;
		}
	}

	public void printList(ListNode head) {
		ListNode temp = head;
		while (temp.next != null) {
			System.out.print(temp.val + " -> ");
			temp = temp.next;
		}
		System.out.print(temp.val);
	}

	public static void main(String[] args) {
		ReorderList obj = new ReorderList();

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		System.out.println("Before Reorder:");
		obj.printList(head);

		System.out.println("\nAfter Reorder:");
		obj.reorderList(head);
		obj.printList(head);
	}

}
