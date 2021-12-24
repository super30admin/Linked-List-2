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

//T.C = O(m+n)
//S.C = O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
       if(headA==null || headB == null)
       {
           return null;
       }
         ListNode curr = headA;
        
        int len1=0;
        while(curr!=null)
        {
            len1++;
            curr =  curr.next;
        }
        
        int len2=0;
        curr = headB;
        
        while(curr!=null)
        {
            len2++;
            curr = curr.next;
        }
        
        while(len2>len1)
        {
            len2--;
            headB=headB.next;
        }
        while(len1>len2)
        {
            len1--;
            headA=headA.next;
        }
        
        while(headA!=headB)
        {
            headA=headA.next;
            headB=headB.next;
        }
        
        return headA;
    }
}