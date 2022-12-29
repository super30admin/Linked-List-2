// Intersection of Two Linked Lists
// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach
// calculate length of both listA & listB
// reduce the gap of the two list, so that after balancing the distance between them, both list will be equi-distant from the intersection.
// then move both list by next location until they reach the same location

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

        int lenA = 0;
        ListNode curr = headA;
        while(curr != null) {
            curr = curr.next;
            lenA++;
        }

        int lenB = 0;
        curr = headB;
        while(curr != null) {
            curr = curr.next;
            lenB++;
        }

        while(lenA > lenB) {
            headA = headA.next;
            lenA--;
        }

        while(lenB > lenA) {
            headB = headB.next;
            lenB--;
        }

        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}