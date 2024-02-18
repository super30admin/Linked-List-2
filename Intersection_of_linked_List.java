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
 //TimeComplexity : O(n)
 //SpaceComplexity:O(1)
 public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        int lenA=0;
        int lenB=0;
        while(temp1 != null) {
            temp1 = temp1.next;
            lenA++;
        }
        while(temp2 != null) {
            temp2 = temp2.next;
            lenB++;
        }
        int count =0;
        int diff = Math.abs(lenA-lenB);
        if(lenA > lenB) {
             while(count < diff) {
                 headA = headA.next;
                 count++;
             }
        } else {
             while(count < diff) {
                 headB = headB.next;
                 count++;
             }
        }

        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}