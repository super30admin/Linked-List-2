// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



public class IntersectionofTwoLL {

	ListNode headA;
	ListNode headB;

	static class ListNode {

		ListNode next;
		int val;

		ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}

	private ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		int lenA = 0, lenB = 0;
		ListNode curr = headA;

		while (curr != null) {
			curr = curr.next;
			lenA++;
		}

		curr = headB;
		while (curr != null) {
			curr = curr.next;
			lenB++;
		}

		while (lenA < lenB) {
			headB = headB.next;
			lenB--;

		}

		while (lenB < lenA) {
			headA = headA.next;
			lenA--;

		}

		while (headA != headB) {
			headA = headA.next;
			headB = headB.next;
		}

		return headA;

	}

	private void printLinkedList(ListNode head) {

		ListNode l = head;

		while (l != null) {
			System.out.println(l.val);
			l = l.next;
		}
	}

	public static void main(String[] args) {

		IntersectionofTwoLL d = new IntersectionofTwoLL();

		d.headA = new ListNode(4);
		d.headA.next = new ListNode(1);
		d.headA.next.next = new ListNode(8);
		d.headA.next.next.next = new ListNode(4);
		d.headA.next.next.next.next = new ListNode(5);

		d.headB = new ListNode(5);
		d.headB.next = new ListNode(0);
		d.headB.next.next = new ListNode(1);
		d.headB.next.next.next = d.headA.next.next;

		ListNode res = d.getIntersectionNode(d.headA, d.headB);
		System.out.println(res.val);
//		d.printLinkedList(d.headA);
//		System.out.println("****************");
//		d.printLinkedList(d.headB);
		// d.head.next.next.next.next.next = new ListNode(6);
//		d.head.next.next.next.next.next.next = new ListNode(7);
//		d.head.next.next.next.next.next.next.next = new ListNode(8);

	}

}
