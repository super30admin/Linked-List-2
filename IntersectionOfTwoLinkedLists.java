package LinkedLists;

import java.util.HashSet;

public class IntersectionOfTwoLinkedLists {

	public static void main(String[] args) {
		ListNode head = new ListNode(4);
		head.next = new ListNode(1);
		head.next.next = new ListNode(8);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		ListNode merge = head.next.next;
		ListNode head2 = new ListNode(5);
		head2.next = new ListNode(0);
		head2.next.next = new ListNode(1);
		head2.next.next.next = merge;
		
		System.out.println(getIntersectionNodeOptimized(head, head2).val);
	}
	
	/**
	 * Using extra space
	 * Time: O(m+n)
	 * Space: O(m) or O(n)
	 * Leetcode accepted: yes
	 * Problems faced: No
	 */
	 public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	        HashSet<ListNode> hs = new HashSet<ListNode>();
			while(headA != null){
	            if(!hs.contains(headA)){
	                hs.add(headA);
	            } 
	            headA = headA.next;
	        }
	        while(headB != null){
	            if(hs.contains(headB)){
	                return headB;
	            } 
	            headB = headB.next;
	        }
	        return null;
	  }

	 /**
	  * Optimized: Two-pointer approach-without using extra space
	  * Time: O(m+n)
      * Space: O(1)
	  * Leetcode accepted: yes
      * Problems faced: No
	  */
	 public static ListNode getIntersectionNodeOptimized(ListNode headA, ListNode headB) {
		 ListNode currA = headA, currB = headB;
		 int lenA = 0, lenB = 0;
		 
		 //Treverse both lists to find their respective lengths
		 while(currA != null) {
			 lenA++;
			 currA = currA.next;
		 }
		 
		 while(currB != null) {
			 lenB++;
			 currB = currB.next;
		 }
		 
		 //Which ever list has the longest length, traverse through that list starting from head one step at a time for the difference in lengths times
		 if(lenA > lenB) {
			 for(int i=0; i<lenA-lenB; i++) {
				 headA = headA.next;
			 }
		 } else {
			 for(int i=0; i<lenB-lenA; i++) {
				 headB = headB.next;
			 }
		 }
		 
		 //Now, traverse through both lists simultaneously to see if they intersect
		 while(headA != null && headB != null) {
			 if(headA.equals(headB)) {
				 return headA;
			 }
			 headA = headA.next;
			 headB = headB.next;
		 }
		 //If no intersection found
		 return null;
	 }
}
