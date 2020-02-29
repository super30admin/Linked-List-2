// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class DeleteNodeNoPointer {

	ListNode head;

	static class ListNode {

		ListNode next;
		int val;

		ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}

	private ListNode deleteNode(ListNode node) {

		ListNode temp = head;
		while (temp != node) {
			temp = temp.next;

		}

		temp.val = temp.next.val;
		temp.next = temp.next.next;

		return head;

	}

	private void printLinkedList(ListNode head) {

		ListNode l = head;

		while (l != null) {
			System.out.println(l.val);
			l = l.next;
		}
	}

	public static void main(String[] args) {

		DeleteNodeNoPointer d = new DeleteNodeNoPointer();
		d.head = new ListNode(1);
		d.head.next = new ListNode(2);
		d.head.next.next = new ListNode(3);
		d.head.next.next.next = new ListNode(4);
		d.head.next.next.next.next = new ListNode(5);
		d.head.next.next.next.next.next = new ListNode(6);
		d.head.next.next.next.next.next.next = new ListNode(7);
		d.head.next.next.next.next.next.next.next = new ListNode(8);

		ListNode res = d.deleteNode(d.head.next.next.next);
		d.printLinkedList(res);

	}

}
