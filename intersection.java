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
        ListNode curr=headA;
        int curA=0;
        int curB=0;
        while(curr!=null)
        {
            curA++;
            curr=curr.next;
        }
        curr=headB;
        while(curr!=null)
        {
            curB++;
            curr=curr.next;
        }
        while(curA>curB)
        {
          headA=headA.next;
          curA--;
        }
        while(curB>curA)
        {
          headB=headB.next;
          curB--;
        }
        while(headA!=headB)
        {
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }
}