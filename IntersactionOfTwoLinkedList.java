//Time Complexity : O(m+n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
public class IntersactionOfTwoLinkedList {

	class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		int lenA = 0, lenB = 0;
		ListNode curr = headA;
		//length of A
		while (curr != null) {
			lenA++;
			curr = curr.next;
		}
		
		//length of B
		curr = headB;
		while (curr != null) {
			lenB++;
			curr = curr.next;
		}
		
		//if lenA is grater traverse the listNode until lenA == lenB
		while (lenA > lenB) {
			headA = headA.next;
			lenA--;
		}
		
		//if lenB is grater traverse the listNode until lenA == lenB
		while (lenA < lenB) {
			headB = headB.next;
			lenB--;
		}
		
		// lenA == lenB return any head bcs it will point to same 
		while (headA != headB) {
			headA = headA.next;
			headB = headB.next;
		}

		return headA;
	}

}
