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
// time complexity 0(m+n)
// space complexity 0(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
        {
            return null;
        }
        int lengtha=0;
        int lengthb=0;
        ListNode curr = headA;
        while(curr!=null)
        {
            curr = curr.next;
            lengtha++;
        }
        curr = headB;
        while(curr!=null)
        {
            curr = curr.next;
            lengthb++;
        }
        while(lengtha>lengthb)
        {
            headA=headA.next;
            lengtha--;
        }
        while(lengthb>lengtha)
        {
            headB=headB.next;
            lengthb--;
        }
        while(headA!=headB)
        {
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }

}