// Time Complexity : O(n); where n is number of nodes in linked list
// Space Complexity : O(1)
class IntersectionOfLinkedLists {	
	static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) { 
		//STEP1: Find length of both the lists
		int lenA=0;
		ListNode curr= headA;
		while(curr!=null) {
			curr=curr.next;
			lenA++;
		}		
		int lenB=0;
		curr= headB;
		while(curr!=null) {
			curr=curr.next;
			lenB++;
		}
		
		//STEP2: Increase the pointer to fill gap of both lengths
		while(lenA > lenB) {
			headA= headA.next;
			lenA--;
		}
		while(lenB > lenA) {
			headB= headB.next;
			lenB--;
		}
		
		//STEP3: Start traversing both the lists and first place where they meet is the intersection point
		while(headA!=headB) {
			headA= headA.next;
			headB= headB.next;
		}
		
		return headA;
	}
}
