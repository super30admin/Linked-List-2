// TC O(M+N)
// SC O(1)
// Approach : 
// First find the lengths of the both the Lists.
// Which ever has more length move the pointer forward to make up for the difference.
// Then traverse traverse until both of then are equal, when both nodes are equal exit.

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
       int aLength = findLenght(headA);
       int bLength = findLenght(headB); 
       while(aLength > bLength){
            headA = headA.next;
            aLength--;
       }
       while(aLength < bLength){
            headB = headB.next;
            bLength--;
       }
       while(headA != headB){
            headA = headA.next;
            headB = headB.next;
       }
       return headA;
    }

    private int findLenght(ListNode head){
        int c = 0;
        while(head != null){
            head = head.next;
            c++;
        } 
        return c;
    }
}
