//Time Complexity : O(n)
//Space Complexity : O(1)

public class IntersectionofTwoLinkedLists {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		ListNode first = headA;
		ListNode second = headB;

		int lenA = 0;
		int lenB = 0;

		while (first != null) {
			first = first.next;
			lenA++;
		}
		while (second != null) {
			second = second.next;
			lenB++;
		}

		while (lenA > lenB) {
			headA = headA.next;
			lenA--;
		}

		while (lenB > lenA) {
			headB = headB.next;
			lenB--;
		}

		while (headA != headB) {
			headA = headA.next;
			headB = headB.next;
		}

		return headA;

	}

}