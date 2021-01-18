/*
 * Time complexity : O(n) 
 * Space complexity : O(n) 
 */
public class ReorderList {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public void reorderList(ListNode head) {

		if (head == null || head.next == null)
			return;

		ListNode slow = head;
		ListNode fast = head;

		while (fast.next != null && fast.next.next != null) {

			slow = slow.next;
			fast = fast.next.next;

		}

		fast = reverse(slow.next);
		slow = head;

		while (fast != null) {
			ListNode temp = slow.next;
			slow.next = fast;
			fast = fast.next;
			slow.next.next = temp;
			slow = temp;
		}

		slow.next = fast;

	}

	private ListNode reverse(ListNode head) {

		ListNode pre = null;
		ListNode curr = head;
		ListNode fast = head.next;

		while (fast != null) {

			curr.next = pre;
			pre = curr;
			curr = fast;
			fast = fast.next;

		}

		curr.next = pre;

		return curr;

	}

}