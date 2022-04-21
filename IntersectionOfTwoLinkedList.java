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
//TC : O(M+N) SC : O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA == null || headB == null) return null;

        int countA = 0;
        int countB = 0;
        ListNode a = headA;
        ListNode b = headB;
        while(a!=null)
        {
            countA++;
            a = a.next;
        }
        while(b!=null)
        {
            countB++;
            b = b.next;
        }
        a=headA;
        b=headB;
        while(countA!=countB)
        {
            if(countA>countB)
            {
                countA--;
                a=a.next;
            }
            else
            {
                countB--;
                b=b.next;
            }
        }

        while(a!=b)
        {
            a=a.next;
            b=b.next;
        }

        return a;
    }
}