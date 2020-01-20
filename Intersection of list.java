// Time complexity 0(m+n) (where m is the size of listA, n is the size of listB)
// Space complexity 0(n)
// code successfully executed in leetcode.

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
        int lenA =0;
        int lenB = 0;
        ListNode current = headA;
        while(current!=null){
            current = current.next;
            lenA++;
        }
        current = headB;
        while(current!=null){
            current = current.next;
            lenB++;
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