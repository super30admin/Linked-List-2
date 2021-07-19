// 160. Intersection of Two Linked Lists - https://leetcode.com/problems/intersection-of-two-linked-lists/
// Time Complexity : O(N)
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
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null && headB == null)
            return headA;
        if(headA == null || headB == null)
            return null;
        ListNode tempA = headA, tempB = headB;
        int m = 0, n = 0;
        //calculate size of both lists
        m = getListSize(headA);
        n = getListSize(headB);
        //move head of larger list so both of them are equal distance from tail
        if(m > n) 
            headA = moveHead(headA, m-n);
        else 
            headB = moveHead(headB, n-m);
        // check if they intersect
        while(headA != null && headB != null) {
            if(headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
        //no intersection
        return null;
    }
    private int getListSize(ListNode head) {
        int ctr = 0;
        while(head != null) {
            head = head.next;
            ctr++;
        }
        return ctr;
    }
    private ListNode moveHead(ListNode head, int ctr) {
        while(ctr != 0) {
            head = head.next;
            ctr--;
        }
        return head;
    }
}