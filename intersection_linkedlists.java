//TC: O(n)
//SC: O(1)
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
        int countA=0;
        int countB=0;
        ListNode ptrA;
        ListNode ptrB;
        int diff=0;
        ptrA=headA;
        ptrB=headB;
        while(ptrA!=null)
        {
            countA++;
            ptrA=ptrA.next;

        }
           while(ptrB!=null)
        {
            countB++;
            ptrB=ptrB.next;

        }
       if(countA>countB)
       diff=countA-countB;
       else
       diff=countB-countA;
       while(diff!=0)
       {
           if(countA>countB)
           {
               headA=headA.next;
           }
           else
           {
               headB=headB.next;
           }
           diff--;
       }
       while(headA!=null)
       {
           if(headA==headB)
           return headA;
           headA=headA.next;
           headB=headB.next;
       }
       return null;
    }
}