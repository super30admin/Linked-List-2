// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class ListNode1 {
	int val;
	ListNode1 next;

	ListNode1() {
	}

	ListNode1(int val) {
		this.val = val;
	}

	ListNode1(int val, ListNode1 next) {
		this.val = val;
		this.next = next;
	}
}

class Reorder_List {
	public void reorderList(ListNode1 head) {
		if (head == null || head.next == null) {
			return;
		}
		ListNode1 slow = head;
		ListNode1 fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		fast = reverseList(slow.next);
		slow.next = null;
		slow = head;
		ListNode1 curr;
		while (fast != null) {
			curr = slow.next;
			slow.next = fast;
			fast = fast.next;
			slow.next.next = curr;
			slow = curr;
		}
	}

	private ListNode1 reverseList(ListNode1 head) {
		ListNode1 curr = head;
		ListNode1 prev = null;
		ListNode1 next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
}