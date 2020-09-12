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
//TimeComplexity=O(n)
//Space Complexity=O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA=0;
        int sizeB=0;
        ListNode a=headA;
        ListNode b=headB;
        while(a!=null)
        {
            sizeA++;
            a=a.next;
        }
        while(b!=null)
        {
            sizeB++;
            b=b.next;
        }
        int diff=Math.abs(sizeA-sizeB);
        if(sizeA>sizeB)
        {
            while(diff>0)
            {
                headA=headA.next;
                diff--;
            }
        }
        else{
            while(diff>0)
            {
                headB=headB.next;
                diff--;
            }
        }
        while(headA!=null &&
             headB!=null)
        {
            if(headA==headB)
            {
                return headA;
            }
            headA=headA.next;
            headB=headB.next;
        }
        return null;
    }
}