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
        ListNode curr = headA;
        while(curr != null){
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
        while(lenA < lenB){
            headB = headB.next;
            lenB--;
        }
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}