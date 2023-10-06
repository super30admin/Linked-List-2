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
//TC: O(N)
//SC: O(1)
public class IntersectionOfLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        ListNode curr = headA;
        while(curr != null) {
            curr = curr.next;
            lenA++;
        } 
        int lenB = 0;
        curr = headB;
        while(curr != null) {
            curr = curr.next;
            lenB++;
        } 

        while(lenA > lenB) {
            headA = headA.next;
            lenA--;
        }

        while(lenB > lenA) {
            headB = headB.next;
            lenB--;
        }

        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
