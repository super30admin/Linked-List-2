package linkedList2;

/*
Idea : 1. Iterate through both the list simultaneously.
	   2. Check until one of the lists ends and move the pointer of that list to other's head and continue.
	   3. A point will come when they will have a common value (result head) at the same time.
	   
Time Complexity : O(2n) where n is the length of the list. (Approx.)2n because both lists 
				  will be traversed once completely, with an extra traversal over one of the lists.
Space Complexity : O(1) because we used a constant space.

Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : no
*/

public class IntersectionOfTwoLinkedLists {

	public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != null || b != null) {
            if (a != null) {
                a = a.next;
            } else {
                headB = headB.next;
            }
            if (b != null) {
                b = b.next;
            } else {
                headA = headA.next;
            }
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
	
}
