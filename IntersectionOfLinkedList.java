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
//Time Complexity : O(M+N), M is the length of first linked list, N is the length of second linked list
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
public class IntersectionOfLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curr = headA;
        int lenA = 0;
        int lenB = 0;
        while(curr != null) {
            curr = curr.next;
            lenA++;
        }
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