// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// comments inline
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lenA = 0, lenB = 0;
        // calculate the length of LinkedList A and B
        ListNode current = headA;
        while (current != null) {
            lenA++;
            current = current.next;
        }

        current = headB;
        while (current != null) {
            lenB++;
            current = current.next;
        }

        // if any of the length beigger than other reduce the len and move the head
        // pointer ahead
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }

        while (lenB > lenA) {
            headB = headB.next;
            lenB--;
        }

        // run till both have same value
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }
}