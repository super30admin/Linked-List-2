
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
 /*
 We find the length of 2 lists. We move the longer list head pointer by some distance such that they both have same distance
 till the end. Then we slide head pointer of both lists by 1 till we find the common node.
 */
public class IntersectionOfTwoLinkedLists {
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