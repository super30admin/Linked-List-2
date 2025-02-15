// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
find lengths of both linked lists; if they are different,
 equalize the start locations, then traverse both lists lock step and compare the next pointer.
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
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int la=0;
        int lb=0;
        ListNode curr=headA;

        while(curr!=null){
            curr=curr.next;
            la++;
        }

        curr=headB;

        while(curr!=null){
            curr=curr.next;
            lb++;
        }

        while(la>lb){
            headA=headA.next;
            la--;
        }

        while(lb>la){
            headB=headB.next;
            lb--;
        }

        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }

        return headA;
    }
}