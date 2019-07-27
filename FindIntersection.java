//Idea: .idea is if two linked list has intersection then it means end element of the both linkedlist should be same.So iterate ove linked list and 
//compare last element values


//Time complexity : O(m+n) where m nad n are length of linkedlist 1 and 2

//Space complexity : O(1)
//Run on leetcode:yes

//any problem faced:yes I did not understand this solution fully.

public class FindIntersection {

		
		//ListNode class
		public static class ListNode {
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


