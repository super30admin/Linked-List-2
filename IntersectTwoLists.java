/**
 * Definition for singly-linked list.
 */ 
 
/*Approach
1) the agenda is to move both headA and headB to null together, to do so we need to move both pointers
thus
2) capture the length of A
3) Reset the pointer to headB
4) capture the length of B
5) calculate the diff not by Math.abs() but checking if lenA>lenB
    -> we move the head pointer of A till B 
    -> else we move the head pointer of B till A
6) now headA and headB start at respective positions till they reference to same location, we can return either A or B
*/

public class IntersectTwoLists {


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int lenA=0, lenB=0;
        
       ListNode curr =headA;
        
        // capture the length of A
        while(curr!=null)
        {
            curr=curr.next;
            lenA++;
        }
        
        // Reset the pointer to headB
        // capture the length of B
        curr =headB;
        while(curr!=null)
        {
            curr=curr.next;
            lenB++;
        }
        
        // calculate the diff not by Math.abs() but checking if lenA>lenB
        // we move the head pointer of A till B 
        // else we move the head pointer of B till A
        
        while(lenA>lenB)
        {
            headA=headA.next;
            lenA--;
        }
        
        while(lenB>lenA)
        {
            headB=headB.next;
            lenB--;
        }
        
        // now headA and headB start at respective positions till they reference to same location, we can return either A or B
        while(headA!=headB)
        {
            headA=headA.next;
            headB=headB.next;
        }
        
        return headA;
        
    }
}