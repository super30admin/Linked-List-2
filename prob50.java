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
        ListNode tempA=headA, tempB=headB;
        while(tempA != tempB){
            if(tempA == null) tempA=headB;
            else tempA=tempA.next;
            if(tempB == null) tempB=headA;
            else tempB=tempB.next;
        }
        return tempA;
    }
}