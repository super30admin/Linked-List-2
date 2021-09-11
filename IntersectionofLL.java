package linkedlistQ;

public class IntersectionofLL {
	 public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	        ListNode currnode=headA;
	        int lenA=0;
	        while(currnode!=null){
	            currnode=currnode.next;
	            lenA++;
	        }
	        currnode=headB;
	            int lenB=0;
	        while(currnode!=null){
	             currnode=currnode.next;
	            lenB++;
	        }
	         while(lenA>lenB){
	            headA=headA.next;
	            lenA--;
	        }
	         while(lenA<lenB){
	            headB=headB.next;
	            lenB--;
	        }
	        while(headA!=headB){
	            headA=headA.next;
	            headB=headB.next;
	        }
	        return headA;
	    }

}
