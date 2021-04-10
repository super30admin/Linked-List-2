/*
Runtime complexity - O(M+N) where M and N is the size of each input list
Space Complexity - O(1) - no extra space is used
*/

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
import java.util.LinkedList; 
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null)
            return null;
        int a=size(headA);
        int b=size(headB);
        int diff=Math.abs(a-b);
        if(a>b)
        {
            while(diff-->0)
            {
                headA=headA.next;
            } 
        }
        else if(b>a)
        {
            while(diff>0)
            {
                headB=headB.next;
                diff=diff-1;
            }            
        }

        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
    public int size(ListNode list1)
    {
        int size_var=0;
        while(list1!=null)
        {
            size_var++;
            list1=list1.next;           
        }
        return size_var;
        //return 1+size(list1.next);
    }
}
