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
//Time complexity: O(n), n is the length of larger list
//Space complexity: O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode first=headA;
        ListNode second=headB;
        int n1=0; int n2=0;
        while(first!=null)
        {
            first=first.next;
            n1++;
        }
        while(second!=null)
        {
            second=second.next;
            n2++;
        }
        if(n1>n2)
        {
        while(n1!=n2)
        {
           headA=headA.next;
            n1--;
        }
        }
        else if(n1<n2)
        {
           while(n1!=n2)
        {
           headB=headB.next;
            n2--;
        } 
        }
        while(headA!=headB)
        {
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
        
    }
}