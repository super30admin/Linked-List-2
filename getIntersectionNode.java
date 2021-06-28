package LinkedList2;


/* Time complexity : o(m+n) - m and n are lengths of two lists
        space complexity: o(1) - no extra space used here
        Did this code run successfully in leetcode : yes
        problems faces : no
        */

public class getIntersectionNode {
	
	 //Definition for singly-linked list.
	 public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
	 
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //find lengths of headA and headB
        int lenA = 0;
        int lenB = 0; 
        
        ListNode curr = headA;
        while(curr != null){
            curr = curr.next;
            lenA++;
        }
        
        curr = headB;
        while(curr != null){
            curr = curr.next;
            lenB++;
        }
        
        while(lenA<lenB){
            headB = headB.next;
            lenB--;
        }
        
        while(lenB<lenA){
            headA = headA.next;
            lenA--;
        }
        
        while(headA!= headB){
            headA = headA.next;
            headB = headB.next;
        }
        
        return headB;
        
        
    }
}
