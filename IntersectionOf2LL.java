
Swapna Singh <swpnsingh17@gmail.com>
Sun, 21 Jun, 11:59 (1 day ago)
to me

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode curr  = headA;
       
        while(curr != null){
            curr = curr.next;
            lenA++;
        }
        curr = headB;
        while( curr != null ){
            curr = curr.next;
            lenB++;
        }
       
        while(lenA > lenB ){
            lenA--;
            headA = headA.next;
        }
       
        while(lenB > lenA) {
            lenB--;
            headB = headB.next;
        }
       
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
       
    }
}
