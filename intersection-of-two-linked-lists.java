// Time Complexity : TC = O(m + n), 
// Space Complexity : SC = O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

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
        // null
        if(headA == null || headB == null) return null;
        ListNode curr = headA;
        int lenA = 0, lenB = 0;
        // calc the length of both LLs
        while(curr != null) {
            ++lenA;
            curr = curr.next;
        }
        curr = headB;
        while(curr != null) {
            ++lenB;
            curr = curr.next;
        }
        // bringing both the heads at the same length starting point
        while(lenA > lenB) {
            headA = headA.next;
            --lenA;
        }
        while(lenB > lenA) {
            headB = headB.next;
            --lenB;
        }
        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}