// Time Complexity : O(n)
// Space Complexity : O(n)
public class ListIntersection {
	 public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	       ListNode curr = headA;
	       int lenA = 0 ; int lenB = 0;
	        while(curr!=null){
	            lenA++;
	            curr = curr.next;
	        }
	        curr = headB;
	        while(curr != null){
	            lenB++;
	            curr = curr.next;
	        }
	        while(lenA > lenB){
	            headA = headA.next;
	            lenA--;
	           
	        }
	         while(lenB > lenA){
	            headB = headB.next;
	            lenB--;
	           
	        }
	         while(headA != headB){
	            headA = headA.next;
	            headB = headB.next;
	           
	        }
	        return headB;
	    } 	
}


