class Solution {
	public void reorderList(ListNode head) {
		if (head == null) return;
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		ListNode h = reverse(slow.next);
		slow.next = null;

		merge(head, h);
	}

	public void merge(ListNode h1, ListNode h2){
		while (h2 != null) {
			ListNode node = h1.next;
			h1.next = h2;
			h1 = h2;
			h2 = node;
		}
	}

	public ListNode reverse(ListNode n) {
		ListNode pre = null;
		while (n != null) {
			ListNode tmp = n.next;
			n.next = pre;
			pre = n;
			n = tmp;
		}
		return pre;
	}
}
