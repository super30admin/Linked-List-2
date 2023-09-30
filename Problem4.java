/*

## Problem2 (https://leetcode.com/problems/reorder-list/)

Time Complexity : O(n+m)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : Na

*/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if(headA == null || headB == null){
            return null;
        }

        ListNode curr = headA;
        int len1 = 0;
        while(curr!=null){
            curr = curr.next;
            len1++;
        }

        curr = headB;
        int len2 = 0;
        while(curr!=null){
            curr = curr.next;
            len2++;
        }

        if(len2 > len1){
            while(len2 > len1){
                headB = headB.next;
                len2--;
            }
        }
        else{
            while(len2 < len1){
                headA = headA.next;
                len1--;
            }
        }

        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }
}