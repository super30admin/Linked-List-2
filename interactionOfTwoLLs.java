// Time Complexity : O(N+M)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

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
        int lenB = 0;
        ListNode curr = headA;
        // taking the count of first LL
        while(curr != null) {
            lenA++;
            curr = curr.next;
        }
        // taking the count of second LL
        curr = headB;
        while(curr != null) {
            lenB++;
            curr = curr.next;
        }
        // whichever is bigger, we are moving the head node to equalise in size with the smaller one
        while(lenA>lenB) {
            headA = headA.next;
            lenA--;
        }
        while(lenB>lenA) {
            headB = headB.next;
            lenB--;
        }
        // once, we have the length same on both LLs,
        // we can traverse on them simultaneously, until we hit the common node
        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}