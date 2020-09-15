/*ProblemNO.160
Write a program to find the node at which the intersection of two singly linked lists begins.*/
public class Intersected {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode x = headA;
		int lenA = 0, lenB = 0;
		while (x != null) {
			x = x.next;
			lenA++;
		}
		x = headB;
		while (x != null) {
			x = x.next;
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
		return headB;
	}
}
