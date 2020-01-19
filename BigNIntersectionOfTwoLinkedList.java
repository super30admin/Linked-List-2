//Time complexity is O(m+n) as we are iterating through two linkedlist length
// space complexity is O(1) as we are not using any extra space.
// This solution is submitted on leetcode

public class BigNIntersectionOfTwoLinkedList {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		
		//edge case
		if(headA ==null || headB ==null)
			return null;
		int lenA = 0;
		int lenB = 0;
		ListNode curr = headA;
		while(curr!=null) {
			curr = curr.next;
			lenA++;
		}
        curr = headB;
		while(curr !=null) {
			curr = curr.next;
			lenB++;
		}
		if(lenA>lenB) {
			int diff = lenA-lenB;
			int count =0;
			ListNode ptrA = headA;
			while(count<diff) {
				ptrA= ptrA.next;
				count++;
			}
			ListNode ptrB = headB;
			while(ptrA!=ptrB) {
				ptrA = ptrA.next;
				ptrB = ptrB.next;
			}
			return ptrA;
		}
		else {
			int diff = lenB-lenA;
			int count =0;
			ListNode ptrB = headB;
			while(count<diff) {
				ptrB= ptrB.next;
				count++;
			}
			ListNode ptrA = headA;
			while(ptrA!=ptrB) {
				ptrA = ptrA.next;
				ptrB = ptrB.next;
			}
			return ptrA;
		}
	}
}
