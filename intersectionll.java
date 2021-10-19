//TC:O(n)
//SC:O(1)
//Successfully ran on leetcode
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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB)
    {
        ListNode a=headA;
        ListNode b=headB;

        int lenA=0;
        int lenB=0;

        while(a!=null)
        {
            a=a.next;
            lenA++;
        }

        while(b!=null)
        {
            b=b.next;
            lenB++;
        }

        a=headA;
        b=headB;

        if(lenA>lenB)
        {
            while(lenA!=lenB)
            {
                a=a.next;
                lenA--;
            }
        }
        else
        {
            while(lenA!=lenB)
            {
                b=b.next;
                lenB--;
            }
        }

        while(a!=null && a!=b)
        {
            a=a.next;
            b=b.next;
        }

        return a;
    }
}
